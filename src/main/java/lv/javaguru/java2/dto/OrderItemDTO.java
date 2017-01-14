package lv.javaguru.java2.dto;

import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.ShoplistEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by DMC on 12/20/2016.
 */
public class OrderItemDTO implements Serializable {

    Long orderID;

    ProductDTO product;

    String productName;

    ShoplistEntityDTO shoplistEntity;

    Integer productQty;

    BigDecimal productPrice;

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public Integer getProductQty() {
        return productQty;
    }

    public void setProductQty(Integer productQty) {
        this.productQty = productQty;
    }

    public BigDecimal getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(BigDecimal productPrice) {
        this.productPrice = productPrice;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }

    public ShoplistEntityDTO getShoplistEntity() {
        return shoplistEntity;
    }

    public void setShoplistEntity(ShoplistEntityDTO shoplistEntity) {
        this.shoplistEntity = shoplistEntity;
    }
/*
    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }
*/
    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    @Override
    public String toString() {
        return "OrderItemDTO{" +
                "orderID=" + orderID +
                ", product=" + product +
                ", shoplistEntity=" + shoplistEntity +
                ", productQty=" + productQty +
                ", productPrice=" + productPrice +
                '}';
    }
}
