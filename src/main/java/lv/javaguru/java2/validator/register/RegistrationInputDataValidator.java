package lv.javaguru.java2.validator.register;

import lv.javaguru.java2.data.registration.RegistrationInputData;
import lv.javaguru.java2.validator.register.rule.RegistrationInputDataRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by DMC on 1/4/2017.
 */

@Component
public class RegistrationInputDataValidator {

    @Autowired
    RegistrationRuleFactory registrationRuleFactory;

    public boolean validate(RegistrationInputData inputData) {

        List<RegistrationInputDataRule> rules = registrationRuleFactory.getRegistrationInputRules();

        for (RegistrationInputDataRule rule : rules) {
            rule.validate(inputData);
        }
        return true;
    }
}
