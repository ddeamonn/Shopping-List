package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.data.InputDataParser;
import lv.javaguru.java2.data.formatter.DataFormatter;
import lv.javaguru.java2.data.report.ReportInputData;
import lv.javaguru.java2.dto.ShoplistEntityDTO;
import lv.javaguru.java2.session.Session;
import lv.javaguru.java2.shoplist.ShoplistManager;
import lv.javaguru.java2.validator.ValidationException;
import lv.javaguru.java2.validator.report.ReportInputDataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * Created by DMC on 1/4/2017.
 */

@Controller
public class DoViewPeriodReportController {

    @Autowired
    Session session;

    @Autowired
    ShoplistManager shoplistManager;

    @Autowired
    @Qualifier("ReportInput")
    InputDataParser<Map, ReportInputData> inputDataParser;

    @Autowired
    @Qualifier("ReportInputDataValidator")
    ReportInputDataValidator reportInputDataValidator;

    @Autowired
    @Qualifier("InputDataReportByPeriodFormatter")
    DataFormatter<ReportInputData, ReportInputData> reportInputDataFormatter;

    @RequestMapping(value = "doViewPeriodReport", method = {RequestMethod.POST})
    public ModelAndView processPost(HttpServletRequest req) {

        ModelAndView modelAndView;

        try {
            ReportInputData inputData = inputDataParser.parse(req.getParameterMap());
            reportInputDataValidator.validate(inputData);

            ReportInputData formattedInputData = reportInputDataFormatter.format(inputData);

            Date startDate = formattedInputData.getStartDate();
            Date endDate = formattedInputData.getEndDate();

            Collection<ShoplistEntityDTO>  shoplistEntitiesDTO = shoplistManager.findUserShoplistOrdersByPeriod(session.getSessionUser(), startDate, endDate);
            modelAndView = doRedirectToReportPage(shoplistEntitiesDTO);
        } catch (ValidationException exception) {
            modelAndView = doRedirectToValidationErrorPage(exception.getMessage());
        } catch(Exception exception) {
            exception.printStackTrace();
            modelAndView = doRedirectToErrorPage();
        }

        return modelAndView;
    }

    private ModelAndView doRedirectToReportPage(Object data) {
        return new ModelAndView("viewreportbyperiod", "report", data);
    }

    private ModelAndView doRedirectToValidationErrorPage(String errorMessage) {
        return new ModelAndView("error", "error", errorMessage);
    }

    private ModelAndView doRedirectToErrorPage() {
        return new ModelAndView("error", "error", "Report validation error occurred");
    }
}
