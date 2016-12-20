package lv.javaguru.java2.domain;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by DMC on 12/20/2016.
 */

public class ShoplistEntity {

    String shoplistName;
    Collection<ShoplistDetails> orders;

    public ShoplistEntity() {
        orders = new ArrayList<ShoplistDetails>();
    }

    public String getShoplistName() {
        return shoplistName;
    }

    public void setShoplistName(String shoplistName) {
        this.shoplistName = shoplistName;
    }

    public void addOrder(ShoplistDetails order) {
        orders.add(order);
    }

    @Override
    public String toString() {
        return "ShoplistEntity{" +
                "shoplistName='" + shoplistName + '\'' +
                ", orders=" + orders +
                '}';
    }
}
