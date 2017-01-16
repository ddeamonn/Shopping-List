package lv.javaguru.java2.database.jpa;

import lv.javaguru.java2.config.SpringConfig;
import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.database.ShoplistEntityDAO;
import lv.javaguru.java2.domain.OrderItem;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.ShoplistEntity;
import lv.javaguru.java2.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.annotation.Order;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static lv.javaguru.java2.domain.ProductBuilder.createProduct;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by DMC on 1/10/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class ShoplistEntityDAOImplTest {

    @Autowired
    ShoplistEntityDAO shoplistEntityDAO;

    @Autowired
    @Qualifier("JPAProduct")
    private ProductDAO productDAO;

    @Test
    public void testCreate() throws Exception {

        User user = new User();
        user.setUserID(1L);
        user.setUserName("User");

        String productName = "name";
        Product product = productDAO.getByName(productName);

        if (product == null) {
            productDAO.create(product);
        }

        productName = "name";
        Product product2 = productDAO.getByName(productName);

        if (product2 == null) {
            productDAO.create(product2);
        }

        OrderItem orderItem = new OrderItem();
        orderItem.setProduct(product);
        orderItem.setProductQty(1);

        OrderItem orderItem2 = new OrderItem();
        orderItem2.setProduct(product2);
        orderItem2.setProductQty(2);

        List<OrderItem> orderItems = new ArrayList<>();
        orderItems.add(orderItem);
        orderItems.add(orderItem2);

        ShoplistEntity shoplistEntity = new ShoplistEntity();

        shoplistEntity.setShoplistName("Food");
        shoplistEntity.setOrderItems(orderItems);
        shoplistEntity.setUser(user);

        ShoplistEntity dbShoplistEntity = shoplistEntityDAO.getByNameAndUser("Food", shoplistEntity.getUser());

        if (dbShoplistEntity != null) {
            shoplistEntityDAO.delete(dbShoplistEntity.getShoplistID());
        }

        shoplistEntityDAO.create(shoplistEntity);

        assertNotNull(shoplistEntity.getShoplistID());
    }

    @Test
    public void testFindByUser() throws Exception {

        User user = new User();
        user.setUserID(1002L);
        user.setUserName("User");

       Collection<ShoplistEntity> shoplistEntities = shoplistEntityDAO.getByUser(user);

        assertNotNull(shoplistEntities);
    }
}
