package lv.javaguru.java2.dto.transformer;

import lv.javaguru.java2.domain.OrderItem;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.dto.OrderItemDTO;
import lv.javaguru.java2.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by DMC on 1/13/2017.
 */

@Component
@Qualifier("OrderItemDTOtoEntity")
public class OrderItemDTOtoEntityTransformer  implements DataTranformer<OrderItem, OrderItemDTO> {
    @Override
    public OrderItem transform(OrderItemDTO dataDTO) {

        OrderItem orderItem = new OrderItem();
        orderItem.setOrderID(dataDTO.getOrderID());
        orderItem.setProductQty(dataDTO.getProductQty());

        orderItem.setProductPrice(dataDTO.getProductPrice());

        return orderItem;
    }
}
