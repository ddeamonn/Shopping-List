package lv.javaguru.java2.validator.register;

import lv.javaguru.java2.config.SpringConfig;
import lv.javaguru.java2.config.WebMVCConfig;
import lv.javaguru.java2.data.registration.RegistrationInputData;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.user.BuildUserHelper;
import lv.javaguru.java2.validator.ValidationException;
import lv.javaguru.java2.validator.register.rule.RegistrationInputDataRule;
import lv.javaguru.java2.validator.register.rule.ValidEmailFormatRule;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.persistence.NoResultException;

/**
 * Created by DMC on 1/4/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class, WebMVCConfig.class} )
@WebAppConfiguration
public class RegistrationInputDataValidatorTest {

    @Autowired
    RegistrationInputDataValidator registrationInputDataValidator;

    @Autowired
    @Qualifier("JPAUser")
    UserDAO userDAO;

    @Autowired
    BuildUserHelper buildUserHelper;

    @Test(expected = ValidationException.class)
    public void userWithSameEmailAlreadyRegistered() {

        RegistrationInputData inputData = new RegistrationInputData();
        inputData.setEmail("user@user.lv");
        inputData.setPassword("password");

        User user = null;
        try {
            user = userDAO.getUserByEmail(inputData.getEmail());

            if (user == null) {
                user = buildUserHelper
                        .createUser()
                        .withRegistrationInputData(inputData)
                        .build();
                userDAO.create(user);
            }
        } catch (NoResultException e) {
            user = buildUserHelper
                    .createUser()
                    .withRegistrationInputData(inputData)
                    .build();
            userDAO.create(user);
        }

        boolean result = registrationInputDataValidator.validate(inputData);
    }

    @Test
    public void newUniqueUserRegistered() {
        RegistrationInputData inputData = new RegistrationInputData();
        inputData.setEmail("user@uniqueemail.com");
        inputData.setPassword("password");
        User dbUser = userDAO.getUserByEmail(inputData.getEmail());

        if (dbUser != null) {
            userDAO.delete(dbUser.getUserID());
        }

        boolean result = registrationInputDataValidator.validate(inputData);
        Assert.assertTrue(result);
    }

    @Test(expected = ValidationException.class)
    public void invalidEmailFormatTest() {
        RegistrationInputData inputData = new RegistrationInputData();
        inputData.setEmail("mail");

        RegistrationInputDataRule rule = new ValidEmailFormatRule();
        rule.validate(inputData);
    }

    @Test(expected = ValidationException.class)
    public void invalidEmailNameFormatTest() {
        RegistrationInputData inputData = new RegistrationInputData();
        inputData.setEmail("@uniqueemail");

        RegistrationInputDataRule rule = new ValidEmailFormatRule();
        rule.validate(inputData);
    }

    @Test(expected = ValidationException.class)
    public void invalidEmailAddressFormatTest() {
        RegistrationInputData inputData = new RegistrationInputData();
        inputData.setEmail("name@");

        RegistrationInputDataRule rule = new ValidEmailFormatRule();
        rule.validate(inputData);
    }

    @Test
    public void validEmailFormatTest() {
        RegistrationInputData inputData = new RegistrationInputData();
        inputData.setEmail("mail@gmail.com");

        RegistrationInputDataRule rule = new ValidEmailFormatRule();
        boolean result = rule.validate(inputData);
        Assert.assertTrue(result);
    }
}
