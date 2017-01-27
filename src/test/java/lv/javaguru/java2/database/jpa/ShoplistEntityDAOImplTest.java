package lv.javaguru.java2.database.jpa;

import lv.javaguru.java2.config.SpringConfig;
import lv.javaguru.java2.config.WebMVCConfig;
import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.database.ShoplistEntityDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.OrderItem;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.ShoplistEntity;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.UserDTO;
import lv.javaguru.java2.dto.transformer.DataTransformer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by DMC on 1/10/2017.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class, WebMVCConfig.class} )
@WebAppConfiguration
public class ShoplistEntityDAOImplTest {

    @Autowired
    ShoplistEntityDAO shoplistEntityDAO;

    @Autowired
    @Qualifier("JPAProduct")
    private ProductDAO productDAO;

    @Autowired
    @Qualifier("JPAUser")
    UserDAO userDAO;

    @Autowired
    @Qualifier("UserToDTOTransformer")
    DataTransformer<UserDTO, User> userToDTOransformer;

    @Test
    public void testCreate() throws Exception {

        List<User> users = userDAO.getAll();
        User mockUser = users.get(0);

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
        shoplistEntity.setUser(mockUser);

        ShoplistEntity dbShoplistEntity = shoplistEntityDAO.getByNameAndUser("Food", shoplistEntity.getUser());

        if (dbShoplistEntity != null) {
            shoplistEntityDAO.delete(dbShoplistEntity.getShoplistID());
        }

        shoplistEntityDAO.create(shoplistEntity);

        assertNotNull(shoplistEntity.getShoplistID());
    }

    @Test
    public void testFindByUser() throws Exception {

        List<User> users = userDAO.getAll();
        User mockUser = users.get(0);

        Collection<ShoplistEntity> shoplistEntities = shoplistEntityDAO.getByUser(mockUser);

        assertNotNull(shoplistEntities);
    }
}
