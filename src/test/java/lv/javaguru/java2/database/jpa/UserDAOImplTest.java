package lv.javaguru.java2.database.jpa;

import lv.javaguru.java2.config.SpringConfig;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.DBUnitTestCase;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.database.jpa.JPAUserDAOImpl;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.shoplist.ShoplistManager;
import lv.javaguru.java2.validator.shoplist.ShoplistInputDataValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static lv.javaguru.java2.domain.UserBuilder.createUser;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class UserDAOImplTest {

    @Autowired
    @Qualifier("JPAUser")
    private UserDAO userDAO;

    @Test
    public void testCreate() throws Exception {
        User user = createUser()
                .withName("L").build();

        userDAO.create(user);

        User userFromDB = userDAO.getById(user.getUserID());
        assertNotNull(userFromDB);
        assertEquals(user.getUserID(), userFromDB.getUserID());
        assertEquals(user.getUserName(), userFromDB.getUserName());
    }

}
