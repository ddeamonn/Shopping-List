package lv.javaguru.java2.database.jpa;

import lv.javaguru.java2.config.SpringConfig;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static lv.javaguru.java2.user.UserBuilder.createUser;
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

        String mail = "mail@mail.com";
        User dbUser = userDAO.getUserByEmail(mail);

        if (dbUser != null) {
            userDAO.delete(dbUser.getUserID());
        }

        User user = createUser()
                .withMail(mail)
                .build();

        userDAO.create(user);

        User userFromDB = userDAO.getById(user.getUserID());
        assertNotNull(userFromDB);
        assertEquals(user.getEmail(), userFromDB.getEmail());
    }

}
