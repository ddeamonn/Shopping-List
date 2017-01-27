package lv.javaguru.java2.dto.transformer;

import lv.javaguru.java2.domain.OrderItem;
import lv.javaguru.java2.domain.ShoplistEntity;
import lv.javaguru.java2.dto.OrderItemDTO;
import lv.javaguru.java2.dto.ShoplistEntityDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by DMC on 1/13/2017.
 */

@Component
@Qualifier("ShoplistEntityWithOrderItemToDTO")
public class ShoplistEntityWithOrderItemToDTOTransformer implements DataTransformer<ShoplistEntityDTO, ShoplistEntity> {

    @Autowired
    @Qualifier("ShoplistEntityToDTO")
    DataTransformer<ShoplistEntityDTO, ShoplistEntity> shoplistEntityToDTOTransformer;

    @Autowired
    @Qualifier("OrderItemToDTO")
    DataTransformer<OrderItemDTO, OrderItem> orderItemToDTOtransformer;

    @Override
    public ShoplistEntityDTO transform(ShoplistEntity shoplistEntity) {
        ShoplistEntityDTO shoplistEntityDTO = shoplistEntityToDTOTransformer.transform(shoplistEntity);

        Collection<OrderItem> orderItems = shoplistEntity.getOrderItems();

        Collection<OrderItemDTO> orderItemDTOs = new ArrayList<>();
        for (OrderItem orderItem : orderItems) {
            OrderItemDTO orderItemDTO = orderItemToDTOtransformer.transform(orderItem);
            orderItemDTOs.add(orderItemDTO);
        }

        shoplistEntityDTO.setOrderItemsDTO(orderItemDTOs);

        return shoplistEntityDTO;
    }
}
