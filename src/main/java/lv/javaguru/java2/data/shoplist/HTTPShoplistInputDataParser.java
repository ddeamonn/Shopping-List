package lv.javaguru.java2.data.shoplist;

import lv.javaguru.java2.data.InputDataParser;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/**
 * Created by DMC on 11/28/2016.
 */

@Component
@Qualifier("shoplistInput")
public class HTTPShoplistInputDataParser implements InputDataParser<Map, ShoplistInputData> {

    Logger logger =  Logger.getLogger(HTTPShoplistInputDataParser.class);

    @Override
    public ShoplistInputData parse(Map requestMap) {

        ShoplistInputData shoplistInputData = new ShoplistInputData();

        String[] shoplistName = (String[])requestMap.get("shoplistName");
        shoplistInputData.setShoplistName(shoplistName[shoplistName.length-1]);

        String[] productNames = (String[])requestMap.get("productName");
        shoplistInputData.setProductNames(new ArrayList<String>(Arrays.asList(productNames)));

        String[] productQty = (String[])requestMap.get("productQty");
        shoplistInputData.setProductQtys(new ArrayList<String>(Arrays.asList(productQty)));

        String[] productPrices = (String[])requestMap.get("productPrice");

        shoplistInputData.setProductPrices(new ArrayList<String>(Arrays.asList(productPrices)));
        return shoplistInputData;
    }
}
