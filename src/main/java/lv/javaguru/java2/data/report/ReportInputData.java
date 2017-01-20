package lv.javaguru.java2.data.report;

import java.util.Date;

/**
 * Created by DMC on 1/19/2017.
 */
public class ReportInputData {

    String inputStartDate;
    String inputEndDate;

    Date startDate;
    Date endDate;

    public String getInputStartDate() {
        return inputStartDate;
    }

    public void setInputStartDate(String inputStartDate) {
        this.inputStartDate = inputStartDate;
    }

    public String getInputEndDate() {
        return inputEndDate;
    }

    public void setInputEndDate(String inputEndDate) {
        this.inputEndDate = inputEndDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
