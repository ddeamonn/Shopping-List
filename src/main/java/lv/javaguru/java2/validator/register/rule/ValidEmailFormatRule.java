package lv.javaguru.java2.validator.register.rule;

import lv.javaguru.java2.data.registration.RegistrationInputData;
import lv.javaguru.java2.validator.ValidationException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

/**
 * Created by DMC on 1/5/2017.
 */
@Component
@Qualifier("ValidEmailRule")
public class ValidEmailFormatRule implements RegistrationInputDataRule {

    private final static String ERROR_MESSAGE = "Incorrect email format";

    @Override
    public boolean validate(RegistrationInputData registrationData) {

        String email = registrationData.getEmail();
        boolean result = isValidEmailAddress(email);

        if (!result) {
            throw new ValidationException(ERROR_MESSAGE);
        }
        return true;
    }

    private  boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddr = new InternetAddress(email);
            emailAddr.validate();
        } catch (AddressException ex) {
            result = false;
        }
        return result;
    }
}
