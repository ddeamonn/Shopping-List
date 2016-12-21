package lv.javaguru.java2.shoplist;

import lv.javaguru.java2.data.shoplist.ShoplistInputData;
import lv.javaguru.java2.domain.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by DMC on 12/21/2016.
 */
@Component
public class PopulateShoplistDataHelper {

    ShoplistEntity populateFromInputData(ShoplistInputData inputData) {
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
}
