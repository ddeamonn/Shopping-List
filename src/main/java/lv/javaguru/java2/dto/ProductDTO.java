package lv.javaguru.java2.dto;

import lv.javaguru.java2.domain.OrderItem;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by DMC on 11/22/2016.
 */
public class ProductDTO {

    private Long productId;

    private String productName;

    private Timestamp addedTime;

    private String addedIP;

    private String productCategory;

    private String addedCountry;

   // public List<OrderItemDTO> orderItems = new ArrayList<>();
    //public OrderItem orderItem;

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

    /*
    public List<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }
*/
/*
    public OrderItem getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(OrderItem orderItem) {
        this.orderItem = orderItem;
    }
*/
    @Override
    public String toString() {
        return "ProductDTO{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", addedTime=" + addedTime +
                ", addedIP='" + addedIP + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", addedCountry='" + addedCountry + '\'' +
                '}';
    }
}
