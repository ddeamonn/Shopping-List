package lv.javaguru.java2.domain;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by DMC on 12/20/2016.
 */
public class ShoplistEntityBuilder {
    String shoplistName;

    private ShoplistEntityBuilder() {};

    private Collection<OrderItem> orderItems;

    public static ShoplistEntityBuilder createShoplistEntity() {
        return new ShoplistEntityBuilder();
    }

    public ShoplistEntity build() {
        ShoplistEntity shoplistEntity = new ShoplistEntity();
        shoplistEntity.setShoplistName(shoplistName);
        shoplistEntity.setOrderItems(orderItems);
        return shoplistEntity;
    }

    public ShoplistEntityBuilder withShoplistName(String shoplistName) {
        this.shoplistName = shoplistName;
        return this;
    }

    public ShoplistEntityBuilder withSholistOrderItems(Collection<OrderItem> orderItems) {
        this.orderItems = orderItems;
        return this;
    }
}
