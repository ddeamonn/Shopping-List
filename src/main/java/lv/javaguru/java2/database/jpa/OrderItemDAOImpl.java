package lv.javaguru.java2.database.jpa;

import lv.javaguru.java2.database.OrderItemDAO;
import lv.javaguru.java2.database.ShoplistDetailsDAO;
import lv.javaguru.java2.domain.OrderItem;
import lv.javaguru.java2.domain.ShoplistDetails;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by DMC on 12/28/2016.
 */

@Component
@Qualifier("JPAShoplist")
public class OrderItemDAOImpl extends GenericHibernateDAOImpl<OrderItem> implements OrderItemDAO {

}
