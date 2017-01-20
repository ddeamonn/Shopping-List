package lv.javaguru.java2.data.formatter;

import lv.javaguru.java2.data.registration.RegistrationInputData;
import lv.javaguru.java2.data.report.ReportInputData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by DMC on 1/4/2017.
 */
@Component
@Qualifier("InputDataReportByPeriodFormatter")
public class InputDataReportByPeriodFormatter implements DataFormatter<ReportInputData, ReportInputData> {

    @Autowired
    @Qualifier("StartDateFormatter")
    DataFormatter<Date, String> startDateFormatter;

    @Autowired
    @Qualifier("EndDateFormatter")
    DataFormatter<Date, String> endDateFormatter;

    public ReportInputData format(ReportInputData inputData) {

        ReportInputData formattedInputData = new ReportInputData();
        String startDate = inputData.getInputStartDate();
        formattedInputData.setStartDate(startDateFormatter.format(startDate));

        String endDate = inputData.getInputEndDate();
        formattedInputData.setEndDate(endDateFormatter.format(endDate));

        return formattedInputData;
    }
}
