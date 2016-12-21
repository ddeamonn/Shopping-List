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

    @Autowired
    PopulateShoplistDataHelper dataHelper;

    public ShoplistEntity populateShoplistFromInputData(ShoplistInputData inputData) {
        return dataHelper.populateFromInputData(inputData);
    }

    public void createShoplist(ShoplistEntity shoplist) throws RuntimeException {

        System.out.println("shoplist added " + shoplist);
    }
}
