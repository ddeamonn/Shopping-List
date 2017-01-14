package lv.javaguru.java2.database.jpa;

import lv.javaguru.java2.config.SpringConfig;
import lv.javaguru.java2.database.OrderItemDAO;
import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.domain.OrderItem;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.ShoplistDetails;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.HashSet;
import java.util.Set;

import static junit.framework.TestCase.assertNotNull;
import static lv.javaguru.java2.domain.ProductBuilder.createProduct;
import static org.junit.Assert.assertEquals;

/**
 * Created by DMC on 1/10/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class OrderItemDAOImplTest {

    @Autowired
    private OrderItemDAO orderItemDAO;

    @Autowired
    @Qualifier("JPAProduct")
    private ProductDAO productDAO;

    @Test
    public void testCreate() throws Exception {

        String productName = "name";
        Product product = productDAO.getByName(productName);

        if (product == null) {
            productDAO.create(product);
        }

        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
       // orderItem.setProductID(product.getProductId());
        orderItem.setProductQty(1);

        orderItemDAO.create(orderItem);
        assertNotNull(orderItem.getOrderID());
    }
}
