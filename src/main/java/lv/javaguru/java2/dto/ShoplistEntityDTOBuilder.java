package lv.javaguru.java2.dto;

import lv.javaguru.java2.domain.ShoplistEntity;

/**
 * Created by DMC on 12/20/2016.
 */
public class ShoplistEntityDTOBuilder {
    String shoplistName;

    private ShoplistEntityDTOBuilder() {};

    public static ShoplistEntityDTOBuilder createShoplistEntity() {
        return new ShoplistEntityDTOBuilder();
    }

    public ShoplistEntityDTO build() {
        ShoplistEntityDTO shoplistEntityDTO = new ShoplistEntityDTO();
        shoplistEntityDTO.setShoplistName(shoplistName);
        return shoplistEntityDTO;
    }

    public ShoplistEntityDTOBuilder withShoplistName(String shoplistName) {
        this.shoplistName = shoplistName;
        return this;
    }
}
