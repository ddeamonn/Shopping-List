package lv.javaguru.java2.validator.register.rule;

import lv.javaguru.java2.data.registration.RegistrationInputData;
import lv.javaguru.java2.validator.ValidationException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by DMC on 11/28/2016.
 */

@Component
@Qualifier("RegistrationPassword")
public class RegistrationPasswordValidatorRule implements RegistrationInputDataRule {
    private final static String IS_EMPTY_ERROR_MESSAGE = "Password is mandatory";
    
    @Override
    public boolean validate(RegistrationInputData registrationData) {
        String inputPassword = registrationData.getPassword();
        if (inputPassword != null && !inputPassword.isEmpty()) {
            return true;
        }
        throw new ValidationException(IS_EMPTY_ERROR_MESSAGE);
    }
}
