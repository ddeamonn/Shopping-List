package lv.javaguru.java2.servlet.mvc.controllers;


import lv.javaguru.java2.dto.UserDTO;
import lv.javaguru.java2.product.ProductManager;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import lv.javaguru.java2.servlet.mvc.ModelAndView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ViewRegistrationFormController implements MVCController {

    @Override
    public MVCModel processGet(HttpServletRequest req) {
        ModelAndView modelAndView = doRedirectToRegistrationPage();
        return new MVCModel(modelAndView.getView(), modelAndView.getData());
    }

    @Override
    public MVCModel processPost(HttpServletRequest req) {
       return new MVCModel("/error.jsp", "Incorrect request");
    }

    private ModelAndView doRedirectToRegistrationPage() {
        return new ModelAndView(null, "/registration.jsp");
    }

}
