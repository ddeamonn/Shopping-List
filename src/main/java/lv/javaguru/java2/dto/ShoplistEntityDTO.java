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

    private Collection<OrderItemDTO> orderItemsDTO;

    UserDTO userDTO;

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

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO user) {
        this.userDTO = user;
    }

    public Collection<OrderItemDTO> getOrderItemsDTO() {
        return orderItemsDTO;
    }

    public void setOrderItemsDTO(Collection<OrderItemDTO> orderItemsDTO) {
        this.orderItemsDTO = orderItemsDTO;
    }

    @Override
    public String toString() {
        return "ShoplistEntityDTO{" +
                "shoplistID=" + shoplistID +
                ", shoplistName='" + shoplistName + '\'' +
                ", orderItems=" + orderItemsDTO +
                ", user=" + userDTO +
                '}';
    }
}
