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

    //@ManyToO(fetch = FetchType.LAZY)
    //@JoinColumn(name = "lst_id")
   // @JoinTable(name = "shopping_list_details", joinColumns = {@JoinColumn( name="prd_id"), @JoinColumn( name="lst_id")})
    //public ShoplistDetails shoplistDetails;

    //@OneToMany (fetch = FetchType.LAZY, mappedBy = "product")
    //public List<OrderItem> orderItems = new ArrayList<>();

    //@OneToOne (fetch = FetchType.EAGER, mappedBy = "product")
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
    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
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
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", addedTime=" + addedTime +
                ", addedIP='" + addedIP + '\'' +
                ", productCategory='" + productCategory + '\'' +
                ", addedCountry='" + addedCountry + '\'' +
                //", orderItems=" + orderItem +
                '}';
    }
}
