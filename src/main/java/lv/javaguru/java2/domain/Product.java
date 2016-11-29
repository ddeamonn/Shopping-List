package lv.javaguru.java2.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

/**
 * Created by DMC on 11/22/2016.
 */
public class Product {

    private String productName;
    private Long productId;
    private Timestamp addedTime;
    private String addedIP;
    private String productCategory;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public Timestamp getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(Timestamp addedTime) {
        this.addedTime = addedTime;
    }

    public String getAddedIP() {
        return addedIP;
    }

    public void setAddedIP(String addedIP) {
        this.addedIP = addedIP;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }
}
