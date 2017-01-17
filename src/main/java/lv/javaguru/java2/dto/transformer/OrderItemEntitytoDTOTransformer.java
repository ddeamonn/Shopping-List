package lv.javaguru.java2.dto.transformer;

import lv.javaguru.java2.domain.OrderItem;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.dto.OrderItemDTO;
import lv.javaguru.java2.dto.ProductDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by DMC on 1/13/2017.
 */

@Component
@Qualifier("OrderItemToDTO")
public class OrderItemEntitytoDTOTransformer implements DataTransformer<OrderItemDTO, OrderItem> {

    @Autowired
    @Qualifier("ProductEntityToDTO")
    DataTransformer<ProductDTO, Product> productToDTOtransformer;

    @Override
    public OrderItemDTO transform(OrderItem orderItem) {

        OrderItemDTO orderItemDTO = new OrderItemDTO();
        orderItemDTO.setOrderID(orderItem.getOrderID());
        ProductDTO productDTO = productToDTOtransformer.transform(orderItem.getProduct());
        orderItemDTO.setProduct(productDTO);
        orderItemDTO.setProductPrice(orderItem.getProductPrice());
        orderItemDTO.setProductQty(orderItem.getProductQty());

        return orderItemDTO;
    }
}
