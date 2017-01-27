package lv.javaguru.java2.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by DMC on 12/20/2016.
 */
@Entity
@Table(name = "order_item")

public class OrderItem implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "order_id", nullable = false)
    Long orderID;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "prd_id")
    Product product;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "lst_id")
    ShoplistEntity shoplistEntity;

    @Column(name = "prd_quantity", nullable = true)
    Integer productQty;

    @Column(name = "prd_price", nullable = true)
    BigDecimal productPrice;

    @Column(name = "ord_item_status", nullable = true)
    String purchaseStatus;

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public ShoplistEntity getShoplistEntity() {
        return shoplistEntity;
    }

    public void setShoplistEntity(ShoplistEntity shoplistEntity) {
        this.shoplistEntity = shoplistEntity;
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

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getPurchaseStatus() {
        return purchaseStatus;
    }

    public void setPurchaseStatus(String purchaseStatus) {
        this.purchaseStatus = purchaseStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderItem orderItem = (OrderItem) o;

        if (orderID != null ? !orderID.equals(orderItem.orderID) : orderItem.orderID != null) return false;
        if (product != null ? !product.equals(orderItem.product) : orderItem.product != null) return false;
        if (shoplistEntity != null ? !shoplistEntity.equals(orderItem.shoplistEntity) : orderItem.shoplistEntity != null)
            return false;
        if (productQty != null ? !productQty.equals(orderItem.productQty) : orderItem.productQty != null) return false;
        return productPrice != null ? productPrice.equals(orderItem.productPrice) : orderItem.productPrice == null;

    }

    @Override
    public int hashCode() {
        int result = orderID != null ? orderID.hashCode() : 0;
        result = 31 * result + (product != null ? product.hashCode() : 0);
        result = 31 * result + (shoplistEntity != null ? shoplistEntity.hashCode() : 0);
        result = 31 * result + (productQty != null ? productQty.hashCode() : 0);
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderID=" + orderID +
                ", shoplistEntity=" + shoplistEntity +
                ", productQty=" + productQty +
                ", productPrice=" + productPrice +
                '}';
    }
}
