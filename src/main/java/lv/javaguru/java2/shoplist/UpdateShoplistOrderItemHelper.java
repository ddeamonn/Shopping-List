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
public class UpdateShoplistOrderItemHelper {

    @Autowired
    @Qualifier("JPAProduct")
    ProductDAO productDAO;

    @Autowired
    OrderItemDAO orderItemDAO;

    @Autowired
    ShoplistEntityDAO shoplistEntityDAO;

    @Autowired
    ProductManager productService;

    @Autowired
    @Qualifier("ShoplistWithOrderItemsDTOtoEntity")
    DataTransformer<ShoplistEntity, ShoplistEntityDTO> shoplistWithOrderItemsDtoToEntity;

    @Autowired
    @Qualifier("ProductDTOtoEntity")
    DataTransformer<Product, ProductDTO> productDtoToEntity;

    @Autowired
    @Qualifier("OrderItemDTOtoEntity")
    DataTransformer<OrderItem, OrderItemDTO> orderItemDtoToEntity;

    @Transactional
    boolean updateStatus(ShoplistEntityDTO shoplistEntityDTO) throws RuntimeException{

        Collection<OrderItemDTO> orderItemDTOs =  shoplistEntityDTO.getOrderItemsDTO();
        if (orderItemDTOs != null) {
            orderItemDTOs.forEach(orderItemDTO ->
            {
                OrderItem orderItem = orderItemDtoToEntity.transform(orderItemDTO);
                orderItemDAO.update(merge(orderItem));
            });
        }

        return true;
    }

    private OrderItem merge(OrderItem orderItem) {
        OrderItem persistedOrderItem = orderItemDAO.getById(orderItem.getOrderID());
        persistedOrderItem.setPurchaseStatus(orderItem.getPurchaseStatus());
        persistedOrderItem.setProductPrice(orderItem.getProductPrice());
        persistedOrderItem.setProductQty(orderItem.getProductQty());

        return persistedOrderItem;
    }
}
