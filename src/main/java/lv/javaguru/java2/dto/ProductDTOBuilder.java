package lv.javaguru.java2.dto;

import lv.javaguru.java2.domain.Product;

import java.sql.Timestamp;

/**
 * Created by DMC on 11/23/2016.
 */

public class ProductDTOBuilder {

    Long productID;
    String productName;
    String ipAddress;
    Timestamp addedTime;
    String productCategory;

    private ProductDTOBuilder() {};

    public static ProductDTOBuilder createProduct() {
        return new ProductDTOBuilder();
    }

    public ProductDTO build() {
        ProductDTO product = new ProductDTO();
        product.setProductId(productID);
        product.setProductName(productName);
        product.setProductCategory(productCategory);
        product.setAddedIP(ipAddress);
        product.setAddedTime(addedTime);
        return product;
    }

    public ProductDTOBuilder withProductID(Long productID) {
        this.productID = productID;
        return this;
    }

    public ProductDTOBuilder withProductName(String productName) {
        this.productName = productName;
        return this;
    }

    public ProductDTOBuilder withProductCategory(String productCategory) {
        this.productCategory = productCategory;
        return this;
    }

    public ProductDTOBuilder withIPAddress(String ipAddress) {
        this.ipAddress = ipAddress;
        return this;
    }

    public ProductDTOBuilder withAddedTime(Timestamp addedTime) {
        this.addedTime = addedTime;
        return this;
    }
}
