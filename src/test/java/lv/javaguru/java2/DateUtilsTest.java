package lv.javaguru.java2;

import lv.javaguru.java2.utils.DateUtils;
import org.junit.Test;

import java.sql.Timestamp;

/**
 * Created by DMC on 11/28/2016.
 */
public class DateUtilsTest {

    @Test
    public void getCurrentTimeTest() {
        Timestamp currentDate = DateUtils.getCurrentTimestamp();

        System.out.println(currentDate);
    }

}
