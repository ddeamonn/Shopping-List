package lv.javaguru.java2.validator.report.rule;

import lv.javaguru.java2.data.registration.RegistrationInputData;
import lv.javaguru.java2.data.report.ReportInputData;

/**
 * Created by DMC on 11/28/2016.
 */

 public interface ReportInputDataRule {
    boolean validate(ReportInputData inputDataData);
}
