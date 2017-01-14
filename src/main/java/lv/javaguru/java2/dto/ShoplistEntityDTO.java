package lv.javaguru.java2.dto;

import lv.javaguru.java2.domain.OrderItem;
import lv.javaguru.java2.domain.User;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by DMC on 1/12/2017.
 */
public class ShoplistEntityDTO {

    private Long shoplistID;

    private String shoplistName;

    private Collection<OrderItemDTO> orderItems = new ArrayList<>();

    User user;

    public Long getShoplistID() {
        return shoplistID;
    }

    public void setShoplistID(Long shoplistID) {
        this.shoplistID = shoplistID;
    }

    public String getShoplistName() {
        return shoplistName;
    }

    public void setShoplistName(String shoplistName) {
        this.shoplistName = shoplistName;
    }

    public Collection<OrderItemDTO> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Collection<OrderItemDTO> orderItems) {
        this.orderItems = orderItems;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ShoplistEntityDTO{" +
                "shoplistID=" + shoplistID +
                ", shoplistName='" + shoplistName + '\'' +
                ", orderItems=" + orderItems.size() +
                ", user=" + user +
                '}';
    }
}
