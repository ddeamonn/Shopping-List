package lv.javaguru.java2.data.formatter.formatters;

import lv.javaguru.java2.data.formatter.DataFormatter;
import lv.javaguru.java2.security.password.PasswordEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by DMC on 1/4/2017.
 */
@Component
@Qualifier("PasswordFormatter")
public class RegistrationPasswordHashFormatter implements DataFormatter<String, String> {

    @Autowired
    PasswordEncoding passwordEncoding;

    @Override
    public String format(String password) {
        return hash (password);
    }

    private String hash(String password)  {
        try {
            return passwordEncoding.getSaltedHash(password);
        } catch (Exception exception) {
            throw new RuntimeException(exception.getMessage());
        }
    }
}
