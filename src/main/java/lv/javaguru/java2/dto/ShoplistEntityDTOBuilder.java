package lv.javaguru.java2.dto;

import lv.javaguru.java2.domain.OrderItem;
import lv.javaguru.java2.domain.ShoplistEntity;
import lv.javaguru.java2.domain.ShoplistEntityBuilder;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Collection;

/**
 * Created by DMC on 12/20/2016.
 */
@Component
public class ShoplistEntityDTOBuilder {
    private String shoplistName;
    private Long shoplistID;
    private Timestamp addedTime;
    private Collection<OrderItemDTO> orderItemDTOs;
    private UserDTO user;

    private ShoplistEntityDTOBuilder() {};

    public static ShoplistEntityDTOBuilder createShoplistEntity() {
        return new ShoplistEntityDTOBuilder();
    }

    public ShoplistEntityDTO build() {
        ShoplistEntityDTO shoplistEntityDTO = new ShoplistEntityDTO();
        shoplistEntityDTO.setShoplistName(shoplistName);
        shoplistEntityDTO.setOrderItemsDTO(orderItemDTOs);
        shoplistEntityDTO.setShoplistID(shoplistID);
        shoplistEntityDTO.setAddedTime(addedTime);
        shoplistEntityDTO.setUserDTO(user);

        return shoplistEntityDTO;
    }

    public ShoplistEntityDTOBuilder withShoplistID(Long shoplistID) {
        this.shoplistID = shoplistID;
        return this;
    }

    public ShoplistEntityDTOBuilder withShoplistName(String shoplistName) {
        this.shoplistName = shoplistName;
        return this;
    }

    public ShoplistEntityDTOBuilder withSholistOrderItems(Collection<OrderItemDTO> orderItemDTOs) {
        this.orderItemDTOs = orderItemDTOs;
        return this;
    }

    public ShoplistEntityDTOBuilder withAddedTime(Timestamp addedTime) {
        this.addedTime = addedTime;
        return this;
    }

    public ShoplistEntityDTOBuilder withUser(UserDTO userDTO) {
        this.user = userDTO;
        return this;
    }
}
