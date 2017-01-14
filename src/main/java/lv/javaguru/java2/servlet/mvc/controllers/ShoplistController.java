package lv.javaguru.java2.servlet.mvc.controllers;


import lv.javaguru.java2.authorisation.AuthorisationContext;
import lv.javaguru.java2.authorisation.AuthorisationService;
import lv.javaguru.java2.product.ProductManager;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import lv.javaguru.java2.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ShoplistController implements MVCController {

    @Autowired
    ProductManager productManager;

    @Autowired
    Session session;

    @Override
    public MVCModel processGet(HttpServletRequest req) {

        String view;
        Object data;

        try {
            if (session.isLoggedUser()) {
                data = productManager.getProducts();
                view = "/shoppinglist.jsp";
            } else {
                view = "/login.jsp";
                data = "Welcome!";
            }
        } catch (Exception exception) {
            view = "/error.jsp";
            data = "Shoplist validation error occurred";
        }

        return new MVCModel(view, data);
    }

    @Override
    public MVCModel processPost(HttpServletRequest req) {
       return new MVCModel("/error.jsp", "Incorrect request");
    }

}
