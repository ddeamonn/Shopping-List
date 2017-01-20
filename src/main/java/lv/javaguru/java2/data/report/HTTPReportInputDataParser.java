package lv.javaguru.java2.data.report;

import lv.javaguru.java2.data.InputDataParser;
import lv.javaguru.java2.data.registration.RegistrationInputData;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * Created by DMC on 11/28/2016.
 */

@Component
@Qualifier("ReportInput")
public class HTTPReportInputDataParser implements InputDataParser<Map, ReportInputData> {

    Logger logger =  Logger.getLogger(HTTPReportInputDataParser.class);

    @Override
    public ReportInputData parse(Map requestMap) {

        ReportInputData inputData = new ReportInputData();

        String[] startDate = (String[])requestMap.get("startDate");
        inputData.setInputStartDate(startDate[startDate.length-1]);

        String[] endDate = (String[])requestMap.get("endDate");
        inputData.setInputEndDate(endDate[endDate.length-1]);

        return inputData;
    }
}
