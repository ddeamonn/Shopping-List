package lv.javaguru.java2.validator.register.rule;

import lv.javaguru.java2.data.registration.RegistrationInputData;
import lv.javaguru.java2.validator.ValidationException;
import org.springframework.stereotype.Component;

/**
 * Created by DMC on 1/31/2017.
 */

@Component
public class RegistrationCorrectPassword implements RegistrationInputDataRule {
    private final static String ERROR_MESSAGE = "Password and repeat password differs";

    @Override
    public boolean validate(RegistrationInputData registrationData) {

        if (!registrationData.getPassword().equals(registrationData.getRepeatPassword())) {
            throw new ValidationException(ERROR_MESSAGE);
        }

        return true;
    }
}
