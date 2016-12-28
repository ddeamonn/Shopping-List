package lv.javaguru.java2.servlet.mvc.controllers;


import lv.javaguru.java2.authorisation.AuthorisationContext;
import lv.javaguru.java2.authorisation.AuthorisationService;
import lv.javaguru.java2.product.ProductManager;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class ShoplistController implements MVCController {

    @Autowired
    @Qualifier("HashAuthorisation")
    AuthorisationService authorisation;

    @Autowired
    ProductManager productManager;

    @Override
    public MVCModel processGet(HttpServletRequest req) {

        String view;
        Object data;

        try {

            AuthorisationContext context = new AuthorisationContext();
            context.setHashNumber("123344");
            authorisation.authorise(context);

            data = productManager.getProducts();
            view = "/startpage.jsp";
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
