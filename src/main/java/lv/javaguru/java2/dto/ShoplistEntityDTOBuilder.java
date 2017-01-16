package lv.javaguru.java2.dto;

import lv.javaguru.java2.domain.OrderItem;
import lv.javaguru.java2.domain.ShoplistEntity;
import lv.javaguru.java2.domain.ShoplistEntityBuilder;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by DMC on 12/20/2016.
 */
@Component
public class ShoplistEntityDTOBuilder {
    String shoplistName;
    Long shoplistID;
    private Collection<OrderItemDTO> orderItemDTOs;

    private ShoplistEntityDTOBuilder() {};

    public static ShoplistEntityDTOBuilder createShoplistEntity() {
        return new ShoplistEntityDTOBuilder();
    }

    public ShoplistEntityDTO build() {
        ShoplistEntityDTO shoplistEntityDTO = new ShoplistEntityDTO();
        shoplistEntityDTO.setShoplistName(shoplistName);
        shoplistEntityDTO.setOrderItemsDTO(orderItemDTOs);
        shoplistEntityDTO.setShoplistID(shoplistID);
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
}
