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
import lv.javaguru.java2.dto.UserDTO;
import lv.javaguru.java2.dto.transformer.DataTransformer;
import lv.javaguru.java2.product.ProductManager;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * Created by DMC on 1/12/2017.
 */

@Component
public class CreateShoplistHelper {

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
    boolean create(ShoplistEntityDTO shoplistEntityDTO) throws RuntimeException{

        ShoplistEntity shoplistEntity = shoplistWithOrderItemsDtoToEntity.transform(shoplistEntityDTO);
        shoplistEntityDAO.create(shoplistEntity);

        Collection<OrderItemDTO> orderItemDTOs =  shoplistEntityDTO.getOrderItemsDTO();
        orderItemDTOs.forEach( orderItemDTO ->
            {
                Product product;
                ProductDTO productDTO = orderItemDTO.getProduct();
                if (isNewProduct(productDTO)) {
                    product = productDtoToEntity.transform(productDTO);
                    productDAO.create(product);
                } else {
                    product = productDAO.getById(productDTO.getProductId());
                }

                OrderItem orderItem = orderItemDtoToEntity.transform(orderItemDTO);
                orderItem.setShoplistEntity(shoplistEntity);
                orderItem.setProduct(product);

                orderItemDAO.create(orderItem);
            });

        return true;
    }

    private boolean isNewProduct(ProductDTO productDTO) {
        return productDTO.getProductId() == null;
    }
}
