package lv.javaguru.java2.user;

import lv.javaguru.java2.config.SpringConfig;
import lv.javaguru.java2.data.registration.RegistrationInputData;
import lv.javaguru.java2.domain.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by DMC on 1/4/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class BuildUserHelperTest {


    @Autowired
    BuildUserHelper buildUserHelper;

    @Test
    public void buildUserHelperTest() {

        RegistrationInputData inputData = new RegistrationInputData();
        inputData.setEmail("email");
        inputData.setPassword("password");

        User  user = buildUserHelper
                .createUser()
                .withRegistrationInputData(inputData)
                .build();

        Assert.assertEquals("email", user.getEmail());
        Assert.assertEquals("password", user.getPassword());
    }
}
