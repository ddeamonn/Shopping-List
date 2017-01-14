package lv.javaguru.java2.data.formatter;

import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.domain.*;
import lv.javaguru.java2.dto.OrderItemDTO;
import lv.javaguru.java2.dto.ProductDTO;
import lv.javaguru.java2.dto.ShoplistEntityDTO;
import lv.javaguru.java2.dto.ShoplistEntityDTOBuilder;
import lv.javaguru.java2.product.ProductManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by DMC on 1/12/2017.
 */

@Component
@Qualifier("ShoplistFormatter")
public class ShoplistEntityFormatter implements DataFormatter<ShoplistEntityDTO, ShoplistEntityDTO> {

    @Autowired
    @Qualifier("JPAProduct")
    ProductDAO productDAO;

    @Autowired
    ProductManager productService;

    //@Autowired
    //@Qualifier("ProductEntityToDTO")
    //DataFormatter<ProductDTO, Product> productEntityToDtoTransformer;

    @Override
    public ShoplistEntityDTO format(ShoplistEntityDTO dataDTO) {
        return preCreate(dataDTO);
    }

    //@Transactional
    private ShoplistEntityDTO preCreate(ShoplistEntityDTO inputShoplistEntityDTO) {

        String shoplistName = inputShoplistEntityDTO.getShoplistName();

        ShoplistEntityDTO shoplistEntityDTO = ShoplistEntityDTOBuilder
                .createShoplistEntity()
                .withShoplistName(shoplistName)
                .build();

        Collection<OrderItemDTO> orderItemsDTO = shoplistEntityDTO.getOrderItems();
        orderItemsDTO.forEach(orderItemDTO ->
        {
            ProductDTO productDTO = orderItemDTO.getProduct();
            orderItemDTO.setProduct(productDTO);
            //Product dbProduct = productDAO.getByName(productDTO.getProductName());
            //ProductDTO dbProductDTO = productEntityToDtoTransformer.format(dbProduct);
           //ProductDTO dbProductDTO = productService.getByName(productDTO.getProductName());

            //if (dbProduct != null) {
            //    orderItemDTO.setProduct(dbProductDTO);
            //} else {
            //    orderItemDTO.setProduct(productDTO);
            //}

            //List<OrderItem> productOrderItems = new ArrayList<>();
            //product.setOrderItems(productOrderItems);
            //productDTO.getOrderItems().add(orderItemDTO);
           // productDAO.create(product);

            orderItemDTO.setShoplistEntity(shoplistEntityDTO);
        });

        shoplistEntityDTO.setOrderItems(orderItemsDTO);

        User user = inputShoplistEntityDTO.getUser();
        shoplistEntityDTO.setUser(user);

        return shoplistEntityDTO;
    }
}
