package lv.javaguru.java2.domain;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by DMC on 12/20/2016.
 */

@Component
public class ShoplistDetailsBuilder {

    Set<Product> products;
    Integer productQty;
    BigDecimal productTotalPrice;

    private ShoplistDetailsBuilder() {};

    public static ShoplistDetailsBuilder createShoplistDetails() {
        return new ShoplistDetailsBuilder();
    }

    public ShoplistDetails build() {
        ShoplistDetails shoplistDetails = new ShoplistDetails();
        //shoplistDetails.setProducts(this.products);
        shoplistDetails.setProductQty(this.productQty);
        return shoplistDetails;
    }

    public ShoplistDetailsBuilder withProducts (Set<Product> products) {
        this.products = products;
        return this;
    }

    public ShoplistDetailsBuilder withProductQty(Integer productQty) {
        this.productQty = productQty;
        return this;
    }
}
