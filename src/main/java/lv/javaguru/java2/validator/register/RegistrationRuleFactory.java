package lv.javaguru.java2.validator.register;

import lv.javaguru.java2.validator.register.rule.RegistrationInputDataRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by DMC on 11/30/2016.
 */

@Component
public class RegistrationRuleFactory {

    @Autowired
    List<RegistrationInputDataRule>  rules;

    public List<RegistrationInputDataRule> getRegistrationInputRules() {
        return rules;
    }
}
