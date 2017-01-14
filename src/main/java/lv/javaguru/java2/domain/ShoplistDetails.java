package lv.javaguru.java2.domain;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by DMC on 12/20/2016.
 */
//@Entity
//@Table(name = "shopping_list_details")

public class ShoplistDetails implements Serializable {

    @Id
    @Column(name = "prd_id",nullable = true)
    Long productID;

    @Id
    @Column(name = "lst_id",nullable = true)
    Long shopListID;

    @OneToMany(fetch = FetchType.LAZY)
    Set<Product> products;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lst_id")
    ShoplistEntity shoplistEntity;

    @Column(name = "prd_quantity", nullable = true)
    Integer productQty;

    @Column(name = "prd_price", nullable = true)
    BigDecimal productTotalPrice;

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

    public Long getProductID() {
        return productID;
    }

    public void setProductID(Long productID) {
        this.productID = productID;
    }

    public Long getShopListID() {
        return shopListID;
    }

    public void setShopListID(Long shopListID) {
        this.shopListID = shopListID;
    }

    @Override
    public String toString() {
        return "ShoplistDetails{" +
                ", productQty=" + productQty +
                ", productTotalPrice=" + productTotalPrice +
                '}';
    }

    @Embeddable
    class ShoplistDetailsID implements Serializable {

        @Column(name = "prd_id",nullable = true)
        Long productID;

        @Column(name = "lst_id",nullable = true)
        Long shopListID;

        @Override
        public int hashCode() {

            int result = (int) (productID ^ (productID >>> 32));
            result = 31 * result + (int) (shopListID ^ (shopListID >>> 32));
            return result;
        }

        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof ShoplistDetailsID)){
                return false;
            }
            ShoplistDetailsID aDetailsID= (ShoplistDetailsID) obj;
            return (this.productID==(aDetailsID.productID))&&
                    (this.shopListID == (aDetailsID.shopListID));
        }
    }
}
