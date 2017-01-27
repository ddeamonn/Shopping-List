package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.OrderItem;
import lv.javaguru.java2.domain.ShoplistDetails;

import java.util.List;

public interface OrderItemDAO {

    void create(OrderItem orderItem);

    OrderItem getById(Long id);

    void delete(Long id);

    void update(OrderItem orderItem);

    void updateStatus(OrderItem orderItem);

    List<OrderItem> getAll();
}
