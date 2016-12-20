package lv.javaguru.java2.domain;

import java.math.BigDecimal;

/**
 * Created by DMC on 12/20/2016.
 */
public class ShoplistDetails {

    Product product;
    Integer productQty;
    BigDecimal productTotalPrice;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getProductQty() {
        return productQty;
    }

    public void setProductQty(Integer productQty) {
        this.productQty = productQty;
    }

    public BigDecimal getProductTotalPrice() {
        return productTotalPrice;
    }

    public void setProductTotalPrice(BigDecimal productTotalPrice) {
        this.productTotalPrice = productTotalPrice;
    }

    @Override
    public String toString() {
        return "ShoplistDetails{" +
                "product=" + product +
                ", productQty=" + productQty +
                ", productTotalPrice=" + productTotalPrice +
                '}';
    }
}
