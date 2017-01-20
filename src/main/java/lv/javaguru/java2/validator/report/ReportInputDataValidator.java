package lv.javaguru.java2.validator.report;

import lv.javaguru.java2.data.registration.RegistrationInputData;
import lv.javaguru.java2.data.report.ReportInputData;
import lv.javaguru.java2.validator.register.RegistrationRuleFactory;
import lv.javaguru.java2.validator.register.rule.RegistrationInputDataRule;
import lv.javaguru.java2.validator.report.rule.ReportInputDataRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by DMC on 1/4/2017.
 */

@Component
@Qualifier("ReportInputDataValidator")
public class ReportInputDataValidator {

    @Autowired
    ReportRuleFactory reportRuleFactory;

    public boolean validate(ReportInputData inputData) {

        List<ReportInputDataRule> rules = reportRuleFactory.getReportRules();

        for (ReportInputDataRule rule : rules) {
            rule.validate(inputData);
        }
        return true;
    }
}
