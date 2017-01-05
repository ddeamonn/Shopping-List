package lv.javaguru.java2.validator.register.rule;

import lv.javaguru.java2.data.registration.RegistrationInputData;
import lv.javaguru.java2.validator.ValidationException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by DMC on 11/28/2016.
 */

@Component
@Qualifier("RegistrationEmail")
public class RegistrationEmailValidatorRule implements RegistrationInputDataRule {
    private final static String IS_EMPTY_ERROR_MESSAGE = "Email is mandatory";
    
    @Override
    public boolean validate(RegistrationInputData registrationData) {
        String inputEmail = registrationData.getEmail();
        if (inputEmail != null && !inputEmail.isEmpty()) {
            return true;
        }
        throw new ValidationException(IS_EMPTY_ERROR_MESSAGE);
    }
}
