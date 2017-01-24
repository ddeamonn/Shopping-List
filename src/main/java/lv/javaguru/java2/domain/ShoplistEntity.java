package lv.javaguru.java2.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by DMC on 12/20/2016.
 */

@Entity
@Table(name="shopping_list")
public class ShoplistEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "lst_id", nullable = false)
    private Long shoplistID;

    @Column(name = "lst_name" , nullable = false)
    private String shoplistName;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shoplistEntity")
    private Collection<OrderItem> orderItems = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usr_id")
    User user;

    @Column(name = "lst_added_time", nullable = true)
    private Timestamp addedTime;

    public Long getShoplistID() {
        return shoplistID;
    }

    public void setShoplistID(Long shoplistID) {
        this.shoplistID = shoplistID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getShoplistName() {
        return shoplistName;
    }

    public void setShoplistName(String shoplistName) {
        this.shoplistName = shoplistName;
    }

    public Collection<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Collection<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public Timestamp getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(Timestamp addedTime) {
        this.addedTime = addedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ShoplistEntity that = (ShoplistEntity) o;

        if (shoplistID != null ? !shoplistID.equals(that.shoplistID) : that.shoplistID != null) return false;
        if (shoplistName != null ? !shoplistName.equals(that.shoplistName) : that.shoplistName != null) return false;
        if (orderItems != null ? !orderItems.equals(that.orderItems) : that.orderItems != null) return false;
        if (user != null ? !user.equals(that.user) : that.user != null) return false;
        return addedTime != null ? addedTime.equals(that.addedTime) : that.addedTime == null;

    }

    @Override
    public int hashCode() {
        int result = shoplistID != null ? shoplistID.hashCode() : 0;
        result = 31 * result + (shoplistName != null ? shoplistName.hashCode() : 0);
        result = 31 * result + (orderItems != null ? orderItems.hashCode() : 0);
        result = 31 * result + (user != null ? user.hashCode() : 0);
        result = 31 * result + (addedTime != null ? addedTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ShoplistEntity{" +
                "shoplistID=" + shoplistID +
                ", shoplistName='" + shoplistName + '\'' +
                ", orderItems=" + orderItems.size() +
                ", user=" + user +
                '}';
    }
}
