package lv.javaguru.java2.servlet.mvc.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ViewRegistrationFormController {

    @RequestMapping(value = "registration", method = { RequestMethod.GET } )
    public ModelAndView processGet(HttpServletRequest req) {
        return doRedirectToRegistrationPage();
    }

    private ModelAndView doRedirectToRegistrationPage() {
        return new ModelAndView("registration","registration",null);
    }

}
