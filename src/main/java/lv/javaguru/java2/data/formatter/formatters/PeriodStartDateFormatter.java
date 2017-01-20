package lv.javaguru.java2.data.formatter.formatters;

import lv.javaguru.java2.data.InputDataException;
import lv.javaguru.java2.data.formatter.DataFormatter;
import lv.javaguru.java2.security.password.PasswordEncoding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by DMC on 1/4/2017.
 */
@Component
@Qualifier("StartDateFormatter")
public class PeriodStartDateFormatter implements DataFormatter<Date, String> {

    private final static String ERROR_MESSAGE = "Incorrect start date";

    @Override
    public Date format(String startDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date formattedStartDate = formatter.parse(startDate);
            return formattedStartDate;
        } catch (ParseException e) {
            throw new InputDataException(ERROR_MESSAGE);
        }
    }
}
