package lv.javaguru.java2.validator.register.rule;

import lv.javaguru.java2.data.registration.RegistrationInputData;
import lv.javaguru.java2.validator.ValidationException;
import org.springframework.stereotype.Component;

/**
 * Created by DMC on 1/31/2017.
 */

@Component
public class RegistrationCorrectEmail implements RegistrationInputDataRule {
    private final static String ERROR_MESSAGE = "email and repeat email differs";

    @Override
    public boolean validate(RegistrationInputData registrationData) {

        if (!registrationData.getEmail().equals(registrationData.getRepeatEmail())) {
            throw new ValidationException(ERROR_MESSAGE);
        }

        return true;
    }
}
