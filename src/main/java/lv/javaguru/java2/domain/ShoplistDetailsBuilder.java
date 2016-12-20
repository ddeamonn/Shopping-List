package lv.javaguru.java2.domain;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by DMC on 12/20/2016.
 */

@Component
public class ShoplistDetailsBuilder {

    Product product;
    Integer productQty;
    BigDecimal productTotalPrice;

    private ShoplistDetailsBuilder() {};

    public static ShoplistDetailsBuilder createShoplistDetails() {
        return new ShoplistDetailsBuilder();
    }

    public ShoplistDetails build() {
        ShoplistDetails shoplistDetails = new ShoplistDetails();
        return shoplistDetails;
    }

    public ShoplistDetailsBuilder withProduct (Product product) {
        this.product = product;
        return this;
    }

    public ShoplistDetailsBuilder withProductQty(Integer productQty) {
        this.productQty = productQty;
        return this;
    }
}
