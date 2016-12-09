package lv.javaguru.java2.database.jdbc;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.javaguru.java2.domain.UserBuilder.createUser;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


public class UserDAOImplTest extends DBUnitTestCase {

    private UserDAO userDAO = new UserDAOImpl();

    @Override
    protected String getDatabaseFile() {
        return "dbscripts/UserDAOImplTest.xml";
    }

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
