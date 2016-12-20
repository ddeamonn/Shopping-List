package lv.javaguru.java2.shoplist;

import lv.javaguru.java2.data.shoplist.ShoplistInputData;
import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by DMC on 11/25/2016.
 */
@Component
public class ShoplistManager {

    //@Autowired
    //ProductDAO productDAO;

    public ShoplistEntity populateShoplistFromInputData(ShoplistInputData inputData) {

        String shoplistName = inputData.getShoplistName();
        List<String> inputProductNames = (List<String>)inputData.getProductNames();
        List<String> inputQtyOfProducts = (List<String>)inputData.getProductQtys();

        ShoplistEntity shoplistEntity = ShoplistEntityBuilder
                .createShoplistEntity()
                .withShoplistName(shoplistName)
                .build();

        int i = 0;
        while (i < inputProductNames.size()) {
            String productName = inputProductNames.get(i);
            Product product = ProductBuilder
                    .createProduct()
                    .withProductName(productName)
                    .build();

            Integer productQty = Integer.parseInt(inputQtyOfProducts.get(i));
            ShoplistDetails shoplistDetails = ShoplistDetailsBuilder
                    .createShoplistDetails()
                    .withProduct(product)
                    .withProductQty(productQty)
                    .build();


            shoplistEntity.addOrder(shoplistDetails);
            i++;
        }

        return shoplistEntity;
    }

    public void createShoplist(ShoplistEntity shoplist) throws RuntimeException {

        System.out.println("shoplist added " + shoplist);
        // productDAO.create(product);
    }
}
