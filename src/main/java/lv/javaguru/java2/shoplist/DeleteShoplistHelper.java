package lv.javaguru.java2.shoplist;

import lv.javaguru.java2.database.OrderItemDAO;
import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.database.ShoplistEntityDAO;
import lv.javaguru.java2.domain.OrderItem;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.ShoplistEntity;
import lv.javaguru.java2.dto.OrderItemDTO;
import lv.javaguru.java2.dto.ProductDTO;
import lv.javaguru.java2.dto.ShoplistEntityDTO;
import lv.javaguru.java2.dto.transformer.DataTransformer;
import lv.javaguru.java2.product.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

/**
 * Created by DMC on 1/12/2017.
 */

@Component
public class DeleteShoplistHelper {

    @Autowired
    OrderItemDAO orderItemDAO;

    @Autowired
    ShoplistEntityDAO shoplistEntityDAO;

    @Autowired
    @Qualifier("ShoplistWithOrderItemsDTOtoEntity")
    DataTransformer<ShoplistEntity, ShoplistEntityDTO> shoplistWithOrderItemsDtoToEntity;

    @Autowired
    @Qualifier("OrderItemDTOtoEntity")
    DataTransformer<OrderItem, OrderItemDTO> orderItemDtoToEntity;

    @Transactional
    boolean delete(ShoplistEntityDTO shoplistEntityDTO) throws RuntimeException{

        Collection<OrderItemDTO> orderItemDTOs = shoplistEntityDTO.getOrderItemsDTO();
        if (orderItemDTOs != null) {
            orderItemDTOs.forEach(orderItemDTO ->
            {
                if (orderItemDTO.getOrderID() != null)
                    orderItemDAO.delete(orderItemDTO.getOrderID());
            });
        }


        ShoplistEntity shoplistEntity = shoplistWithOrderItemsDtoToEntity.transform(shoplistEntityDTO);
        shoplistEntityDAO.delete(shoplistEntity.getShoplistID());

        return true;
    }
}
