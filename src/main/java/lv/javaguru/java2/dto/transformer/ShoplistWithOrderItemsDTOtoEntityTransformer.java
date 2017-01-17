package lv.javaguru.java2.dto.transformer;

import lv.javaguru.java2.database.OrderItemDAO;
import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.database.ShoplistEntityDAO;
import lv.javaguru.java2.domain.OrderItem;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.ShoplistEntity;
import lv.javaguru.java2.dto.OrderItemDTO;
import lv.javaguru.java2.dto.ProductDTO;
import lv.javaguru.java2.dto.ShoplistEntityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by DMC on 1/13/2017.
 */
@Component
@Qualifier("ShoplistWithOrderItemsDTOtoEntity")
public class ShoplistWithOrderItemsDTOtoEntityTransformer implements DataTransformer<ShoplistEntity, ShoplistEntityDTO> {

    @Autowired
    @Qualifier("ShoplistDTOtoEntity")
    DataTransformer<ShoplistEntity, ShoplistEntityDTO> shoplistDTOToEntityTransformer;

    @Autowired
    @Qualifier("ProductDTOtoEntity")
    DataTransformer<Product, ProductDTO> productDtoToEntityTransformer;

    @Autowired
    @Qualifier("OrderItemDTOtoEntity")
    DataTransformer<OrderItem, OrderItemDTO> orderDTOToEntityTransformer;

    @Autowired
    OrderItemDAO orderItemDAO;

    @Autowired
    ShoplistEntityDAO shoplistEntityDAO;

    ShoplistEntity shoplistEntity;

    @Override
    public ShoplistEntity transform(ShoplistEntityDTO dataDTO) {

        shoplistEntity = shoplistDTOToEntityTransformer.transform(dataDTO);

        List<OrderItem> shoplistOrderItems = populateShoplistOrderItems(dataDTO);
        shoplistEntity.setOrderItems(shoplistOrderItems);

        return shoplistEntity;
    }

    private List<OrderItem> populateShoplistOrderItems(ShoplistEntityDTO shoplistEntityDTO) {

        List<OrderItem> shoplistOrderItems = new ArrayList<>();
        Collection<OrderItemDTO> orderItemsDTO = shoplistEntityDTO.getOrderItemsDTO();
        orderItemsDTO.forEach(orderItemDTO ->
        {
            OrderItem orderItem = orderDTOToEntityTransformer.transform(orderItemDTO);
            orderItem.setShoplistEntity(shoplistEntity);
            ProductDTO productDTO = orderItemDTO.getProduct();
            Product product = productDtoToEntityTransformer.transform(productDTO);
           // Product product = findOrderProduct(orderItemDTO);
            orderItem.setProduct(product);
            shoplistOrderItems.add(orderItem);
        });

        return shoplistOrderItems;
    }

}
