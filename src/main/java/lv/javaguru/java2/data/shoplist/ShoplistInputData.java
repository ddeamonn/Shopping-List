package lv.javaguru.java2.data.shoplist;

import java.util.Collection;

/**
 * Created by DMC on 12/20/2016.
 */
public class ShoplistInputData {
    String shoplistID;
    String shoplistName;
    Collection<String>  productNames;
    Collection<String> productQtys;
    Collection<String> productPrices;

    public String getShoplistID() {
        return shoplistID;
    }

    public void setShoplistID(String shoplistID) {
        this.shoplistID = shoplistID;
    }

    public String getShoplistName() {
        return shoplistName;
    }

    public void setShoplistName(String shoplistName) {
        this.shoplistName = shoplistName;
    }

    public Collection<String> getProductNames() {
        return productNames;
    }

    public void setProductNames(Collection<String> productNames) {
        this.productNames = productNames;
    }

    public Collection<String> getProductQtys() {
        return productQtys;
    }

    public void setProductQtys(Collection<String> productQtys) {
        this.productQtys = productQtys;
    }

    public Collection<String> getProductPrices() {
        return productPrices;
    }

    public void setProductPrices(Collection<String> productPrices) {
        this.productPrices = productPrices;
    }
}
