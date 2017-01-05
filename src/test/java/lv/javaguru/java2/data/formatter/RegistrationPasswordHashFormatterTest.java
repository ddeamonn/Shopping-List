package lv.javaguru.java2.data.formatter;

import lv.javaguru.java2.config.SpringConfig;
import lv.javaguru.java2.data.formatter.formatters.RegistrationPasswordHashFormatter;
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
public class RegistrationPasswordHashFormatterTest {

    @Autowired
    @Qualifier("PasswordFormatter")
    DataFormatter<String, String> formatter;

    @Test
    public void hashPasswordTest() {

        String password = "password";
        String hashedPassword = formatter.format(password);
        Assert.assertNotEquals(null, hashedPassword);
        Assert.assertNotEquals("", hashedPassword);
        Assert.assertNotEquals(password, hashedPassword);
    }
}
