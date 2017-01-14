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

    //@OneToOne(fetch = FetchType.LAZY)
    //@JoinColumn(name = "prd_id")
   // @JoinTable(name = "products", joinColumns = @JoinColumn( name="prd_id"))
    //Product product;
    //@Column(name="prd_id")
   // Long productID;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "prd_id")
    //@JoinTable(name = "products", joinColumns = @JoinColumn( name="prd_id"))
    Product product;

    @ManyToOne(fetch = FetchType.LAZY, cascade=CascadeType.ALL)
    @JoinColumn(name = "lst_id")
    ShoplistEntity shoplistEntity;

    @Column(name = "prd_quantity", nullable = true)
    Integer productQty;

    @Column(name = "prd_price", nullable = true)
    BigDecimal productPrice;

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }
/*
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
*/
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

    /*
        public Long getProductID() {
            return productID;
        }

        public void setProductID(Long productID) {
            this.productID = productID;
        }
    */
    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
                "orderID=" + orderID +
                //", productID=" + productID +
                ", shoplistEntity=" + shoplistEntity +
                ", productQty=" + productQty +
                ", productPrice=" + productPrice +
                '}';
    }
}
