package lv.javaguru.java2.data.formatter.formatters;

import lv.javaguru.java2.data.InputDataException;
import lv.javaguru.java2.data.formatter.DataFormatter;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by DMC on 1/4/2017.
 */
@Component
@Qualifier("EndDateFormatter")
public class PeriodEndDateFormatter implements DataFormatter<Date, String> {

    private final static String ERROR_MESSAGE = "Incorrect end date";

    @Override
    public Date format(String endDate) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date formattedEndDate = formatter.parse(endDate);
            formattedEndDate = new Date(formattedEndDate.getTime() + TimeUnit.DAYS.toMillis(1));
            return formattedEndDate;
        } catch (ParseException e) {
            throw new InputDataException(ERROR_MESSAGE);
        }
    }
}
