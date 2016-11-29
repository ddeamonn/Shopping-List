package lv.javaguru.java2.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by DMC on 11/23/2016.
 */
public class ProductBuilder {

    String productName;
    String ipAddress;
    Timestamp addedTime;
    String productCategory;

    private ProductBuilder() {};

    public static ProductBuilder createProduct() {
        return new ProductBuilder();
    }

    public Product build() {
        Product product = new Product();
        product.setProductName(productName);
        product.setProductCategory(productCategory);
        product.setAddedIP(ipAddress);
        product.setAddedTime(addedTime);
        return product;
    }

    public ProductBuilder withProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public ProductBuilder withProductCategory(String productCategory) {
        this.productCategory = productCategory;
        return this;
    }

    public ProductBuilder withIPAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public ProductBuilder withAddedTime(Timestamp addedTime) {
        this.addedTime = addedTime;
        return this;
    }
}
