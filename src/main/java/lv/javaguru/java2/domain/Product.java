package lv.javaguru.java2.domain;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DMC on 11/22/2016.
 */
@Entity
@Table(name="products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "prd_id", nullable = true)
    private Long productId;

    @Column(name = "prd_name", nullable = false)
    private String productName;

    @Column(name = "prd_added_time", nullable = true)
    private Timestamp addedTime;

    @Column(name = "prd_added_ip", nullable = true)
    private String addedIP;

    @Column(name = "prd_category", nullable = true)
    private String productCategory;

    @Column(name = "prd_added_country", nullable = true)
    private String addedCountry;

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

    public String getAddedCountry() {
        return addedCountry;
    }

    public void setAddedCountry(String addedCountry) {
        this.addedCountry = addedCountry;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", addedTime=" + addedTime +
                ", addedIP='" + addedIP + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", addedCountry='" + addedCountry + '\'' +
                '}';
    }
}
