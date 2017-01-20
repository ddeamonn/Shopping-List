package lv.javaguru.java2.validator.report.rule;

import lv.javaguru.java2.data.report.ReportInputData;
import lv.javaguru.java2.validator.ValidationException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by DMC on 11/28/2016.
 */

@Component
@Qualifier("ReportEndDateRule")
public class ReportEndDateValidatorRule implements ReportInputDataRule {
    private final static String ERROR_MESSAGE = "End date is mandatory";
    
    @Override
    public boolean validate(ReportInputData inputData) {
        String inputDate = inputData.getInputEndDate();
        if (inputDate != null && !inputDate.isEmpty()) {
            return true;
        }
        throw new ValidationException(ERROR_MESSAGE);
    }
}
