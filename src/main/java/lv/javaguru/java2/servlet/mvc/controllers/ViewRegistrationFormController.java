package lv.javaguru.java2.servlet.mvc.controllers;


import lv.javaguru.java2.product.ProductManager;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ViewRegistrationFormController implements MVCController {

    @Override
    public MVCModel processGet(HttpServletRequest req) {

        String view;
        Object data = null;
        try {
            view = "/registration.jsp";
        } catch (Exception exception) {
            view = "/error.jsp";
            data = "Error";
        }

        return new MVCModel(view, data);
    }

    @Override
    public MVCModel processPost(HttpServletRequest req) {
       return new MVCModel("/error.jsp", "Incorrect request");
    }

}
