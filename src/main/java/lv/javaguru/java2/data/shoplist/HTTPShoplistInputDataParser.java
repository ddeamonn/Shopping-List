package lv.javaguru.java2.data.shoplist;

import lv.javaguru.java2.data.InputDataParser;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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

        String[] buttonUpdate = (String[])requestMap.get("update");
        String[] buttonSave = (String[])requestMap.get("save");
        String[] buttonDelete = (String[])requestMap.get("delete");

        String[] shoplistID = (String[])requestMap.get("orders");
        if (shoplistID != null)
            shoplistInputData.setShoplistID(shoplistID[shoplistID.length-1]);

        shoplistID = (String[])requestMap.get("shoplistID");
        if (shoplistID != null)
            shoplistInputData.setShoplistID(shoplistID[shoplistID.length-1]);

        String[] shoplistName = (String[])requestMap.get("shoplistName");
        if (shoplistName != null)
            shoplistInputData.setShoplistName(shoplistName[shoplistName.length-1]);

        String[] productNames = (String[])requestMap.get("productName");
        if(productNames != null)
            shoplistInputData.setProductNames(new ArrayList<String>(Arrays.asList(productNames)));

        String[] orderItemIDs = (String[])requestMap.get("orderItemID");
        if (orderItemIDs != null)
            shoplistInputData.setOrderItemsIDs(new ArrayList<String>(Arrays.asList(orderItemIDs)));

        String[] productQty = (String[])requestMap.get("productQty");
        if (productQty != null)
            shoplistInputData.setProductQtys(new ArrayList<String>(Arrays.asList(productQty)));

        String[] productPrices = (String[])requestMap.get("productPrice");
        if (productPrices != null)
            shoplistInputData.setProductPrices(new ArrayList<String>(Arrays.asList(productPrices)));

        if (productNames !=null) {
            List<String> purchaseStatuses = new ArrayList();
            for (int i = 0; i < productNames.length; i++) {
                purchaseStatuses.add(getPurchaseStatus(requestMap, i));
            }

            shoplistInputData.setPurchaseStatuses(purchaseStatuses);
        }

        return shoplistInputData;
    }

    private String getPurchaseStatus(Map requestMap, int i) {
        String[] inputPurchaseStatusArr = (String[])requestMap.get("productStatus" + i);
        String inputPurchaseStatus;
        if (inputPurchaseStatusArr == null) {
            inputPurchaseStatus = "off";
        } else {
            inputPurchaseStatus = "on";
        }

        return inputPurchaseStatus;
    }
}
