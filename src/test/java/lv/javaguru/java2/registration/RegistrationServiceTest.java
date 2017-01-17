package lv.javaguru.java2.registration;

import lv.javaguru.java2.config.SpringConfig;
import lv.javaguru.java2.data.registration.RegistrationInputData;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.user.BuildUserHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by DMC on 1/4/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class RegistrationServiceTest {

    @Autowired
    BuildUserHelper buildUserHelper;

    @Autowired
    Registration registration;

    @Autowired
    @Qualifier("JPAUser")
    UserDAO userDAO;

    @Test
    public void registerNewUserTest() throws Exception {

        RegistrationInputData inputData = new RegistrationInputData();
        inputData.setEmail("emailunique@mail2.lv");
        inputData.setPassword("password");

        User user = buildUserHelper
                .createUser()
                .withRegistrationInputData(inputData)
                .withCurrentAddedTime()
                .build();

        User dbUser = userDAO.getUserByEmail(user.getEmail());

        if (dbUser != null) {
            userDAO.delete(dbUser.getUserID());
        }

        registration.register(user);

        dbUser = userDAO.getUserByEmail(user.getEmail());

        Assert.assertEquals(dbUser.getEmail(), user.getEmail());
    }
}
