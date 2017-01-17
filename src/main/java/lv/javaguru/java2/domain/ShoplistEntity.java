package lv.javaguru.java2.domain;

import javax.persistence.*;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "shoplistEntity", cascade=CascadeType.ALL)
    private Collection<OrderItem> orderItems = new HashSet<>();

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "usr_id")
    User user;

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
