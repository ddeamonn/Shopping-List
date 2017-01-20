package lv.javaguru.java2.validator.report.rule;

import lv.javaguru.java2.data.registration.RegistrationInputData;
import lv.javaguru.java2.data.report.ReportInputData;
import lv.javaguru.java2.validator.ValidationException;
import lv.javaguru.java2.validator.register.rule.RegistrationInputDataRule;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by DMC on 11/28/2016.
 */

@Component
@Qualifier("ReportStartDateRule")
public class ReportStartDateValidatorRule implements ReportInputDataRule {
    private final static String ERROR_MESSAGE = "Start date is mandatory";
    
    @Override
    public boolean validate(ReportInputData inputData) {
        String inputDate = inputData.getInputStartDate();
        if (inputDate != null && !inputDate.isEmpty()) {
            return true;
        }
        throw new ValidationException(ERROR_MESSAGE);
    }
}
