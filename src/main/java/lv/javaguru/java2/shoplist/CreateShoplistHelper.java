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
import lv.javaguru.java2.dto.transformer.DataTranformer;
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
    @Qualifier("ProductDTOtoEntity")
    DataTranformer<Product, ProductDTO> productDtoToEntityTransformer;

    @Autowired
    @Qualifier("OrderItemDTOtoEntity")
    DataTranformer<OrderItem, OrderItemDTO> orderDTOToEntityTransformer;

    @Autowired
    @Qualifier("UserDTOtoEntity")
    DataTranformer<User, UserDTO> userDTOToEntityTransformer;

    List<OrderItem> shoplistOrderItems;

    ShoplistEntity shoplistEntity;

    @Transactional
    boolean create(ShoplistEntityDTO shoplistEntityDTO) throws RuntimeException{

        ShoplistEntity shoplistEntity = populateShoplistEntity(shoplistEntityDTO);

        shoplistEntityDAO.create(shoplistEntity);

        return true;
    }

    private ShoplistEntity populateShoplistEntity(ShoplistEntityDTO shoplistEntityDTO) {

        shoplistEntity = new ShoplistEntity();
        shoplistEntity.setShoplistName(shoplistEntityDTO.getShoplistName());
        shoplistEntityDTO.setAddedTime(DateUtils.getCurrentTimestamp());

        User user = userDTOToEntityTransformer.transform(shoplistEntityDTO.getUserDTO());
        shoplistEntity.setUser(user);

        shoplistOrderItems = new ArrayList<>();
        populateShoplistOrderItems(shoplistEntityDTO);
        shoplistEntity.setOrderItems(shoplistOrderItems);

        return shoplistEntity;
    }

    private void populateShoplistOrderItems(ShoplistEntityDTO shoplistEntityDTO) {
        Collection<OrderItemDTO> orderItemsDTO = shoplistEntityDTO.getOrderItemsDTO();
        orderItemsDTO.forEach(orderItemDTO ->
        {
            OrderItem orderItem = orderDTOToEntityTransformer.transform(orderItemDTO);
            orderItem.setShoplistEntity(shoplistEntity);
            Product product = findOrCreateOrderProduct(orderItemDTO);
            orderItem.setProduct(product);
            shoplistOrderItems.add(orderItem);
        });
    }

    private Product findOrCreateOrderProduct(OrderItemDTO orderItemDTO) {
        ProductDTO productDTO = orderItemDTO.getProduct();
        Product product = productDAO.getByName(productDTO.getProductName());
        if (!isProduct(product)) {
            product = productDtoToEntityTransformer.transform(productDTO);
            productDAO.create(product);
        }

        return product;
    }

    private boolean isProduct(Product product) {
        return !(product == null);
    }
}
