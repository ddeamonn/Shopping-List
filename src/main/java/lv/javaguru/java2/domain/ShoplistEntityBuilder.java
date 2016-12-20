package lv.javaguru.java2.domain;

/**
 * Created by DMC on 12/20/2016.
 */
public class ShoplistEntityBuilder {
    String shoplistName;

    private ShoplistEntityBuilder() {};

    public static ShoplistEntityBuilder createShoplistEntity() {
        return new ShoplistEntityBuilder();
    }

    public ShoplistEntity build() {
        ShoplistEntity shoplistEntity = new ShoplistEntity();
        shoplistEntity.setShoplistName(shoplistName);
        return shoplistEntity;
    }

    public ShoplistEntityBuilder withShoplistName(String shoplistName) {
        this.shoplistName = shoplistName;
        return this;
    }
}
