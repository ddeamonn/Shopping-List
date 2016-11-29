package lv.javaguru.java2.data;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Calendar;

/**
 * Created by DMC on 11/28/2016.
 */
public class DateUtils {
    public static Timestamp getCurrentTimestamp() {

        DateFormat df = DateFormat.getTimeInstance();
        Calendar cal = Calendar.getInstance();

        return new Timestamp(cal.getTimeInMillis());
    }
}
