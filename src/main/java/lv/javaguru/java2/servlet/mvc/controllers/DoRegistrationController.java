package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.registration.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by DMC on 1/4/2017.
 */

@Controller
public class DoRegistrationController {

    @Autowired
    RegistrationService registrationService;

    @RequestMapping(value = "doRegistration", method = { RequestMethod.POST } )
    public ModelAndView processPost(HttpServletRequest req) {

        registrationService.parseAndCollectInputData(req.getParameterMap());
        registrationService.process();

        return registrationService.getModelAndView();
    }

}
