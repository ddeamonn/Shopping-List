package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.data.InputDataParser;
import lv.javaguru.java2.data.registration.RegistrationInputData;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.data.formatter.DataFormatter;
import lv.javaguru.java2.registration.Registration;
import lv.javaguru.java2.registration.RegistrationService;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import lv.javaguru.java2.servlet.mvc.ModelAndView;
import lv.javaguru.java2.user.BuildUserHelper;
import lv.javaguru.java2.validator.ValidationException;
import lv.javaguru.java2.validator.register.RegistrationInputDataValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by DMC on 1/4/2017.
 */

@Component
public class DoRegistrationController implements MVCController {

    @Autowired
    RegistrationService registrationService;

    @Override
    public MVCModel processPost(HttpServletRequest req) {

        registrationService.parseAndCollectInputData(req.getParameterMap());
        registrationService.process();

        ModelAndView modelAndView = registrationService.getModelAndView();

        String view = modelAndView.getView();

        Object data = modelAndView.getData();

        return new MVCModel(view, data);
    }

    @Override
    public MVCModel processGet(HttpServletRequest req) {
        return new MVCModel("/error.jsp", "Incorrect request");
    }
}
