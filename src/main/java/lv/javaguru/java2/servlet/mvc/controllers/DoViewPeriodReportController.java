package lv.javaguru.java2.servlet.mvc.controllers;

import com.sun.xml.internal.bind.v2.TODO;
import lv.javaguru.java2.data.InputDataParser;
import lv.javaguru.java2.data.formatter.DataFormatter;
import lv.javaguru.java2.data.report.ReportInputData;
import lv.javaguru.java2.data.shoplist.ShoplistInputData;
import lv.javaguru.java2.domain.ShoplistEntity;
import lv.javaguru.java2.dto.ShoplistEntityDTO;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import lv.javaguru.java2.servlet.mvc.ModelAndView;
import lv.javaguru.java2.session.Session;
import lv.javaguru.java2.shoplist.ShoplistManager;
import lv.javaguru.java2.validator.ValidationException;
import lv.javaguru.java2.validator.report.ReportInputDataValidator;
import lv.javaguru.java2.validator.shoplist.ShoplistIDValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.Date;
import java.util.Map;

/**
 * Created by DMC on 1/4/2017.
 */

@Component
public class DoViewPeriodReportController implements MVCController {

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

    public MVCModel processPost(HttpServletRequest req) {

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

        Object data = modelAndView.getData();
        String view = modelAndView.getView();

        return new MVCModel(view, data);
    }

    @Override
    public MVCModel processGet(HttpServletRequest req) {
        return new MVCModel("/error.jsp", "Incorrect request");
    }

    private ModelAndView doRedirectToReportPage(Object data) {
        return new ModelAndView(data, "/viewreportbyperiod.jsp");
    }

    private ModelAndView doRedirectToValidationErrorPage(String errorMessage) {
        return new ModelAndView(errorMessage, "/error.jsp");
    }

    private ModelAndView doRedirectToErrorPage() {
        return new ModelAndView("Report validation error occurred", "/error.jsp");
    }
}
