package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.authorisation.AuthorisationContext;
import lv.javaguru.java2.authorisation.AuthorisationService;
import lv.javaguru.java2.dto.ShoplistEntityDTO;
import lv.javaguru.java2.dto.UserDTO;
import lv.javaguru.java2.registration.RegistrationService;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import lv.javaguru.java2.servlet.mvc.ModelAndView;
import lv.javaguru.java2.session.Session;
import lv.javaguru.java2.shoplist.ShoplistManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

/**
 * Created by DMC on 1/4/2017.
 */

@Component
public class DoAuthorisationController implements MVCController {

    @Autowired
    @Qualifier("LoginAuthorisation")
    AuthorisationService authorisation;

    @Autowired
    Session session;

    @Autowired
    ShoplistManager shoplistManager;

    @Override
    public MVCModel processPost(HttpServletRequest req) {

        AuthorisationContext context = new AuthorisationContext();
        context.setHashNumber("123344");
        authorisation.authorise(context);

        ModelAndView modelAndView = doRedirectToUserPage();
        String view = modelAndView.getView();

        Object data = modelAndView.getData();

        return new MVCModel(view, data);
    }

    @Override
    public MVCModel processGet(HttpServletRequest req) {
        return new MVCModel("/error.jsp", "Incorrect request");
    }

    private ModelAndView doRedirectToUserPage() {

        UserDTO userDTO = session.getSessionUser();
        return new ModelAndView(shoplistManager.findUserShoplistOrders(userDTO), "/shoppinglist.jsp");
    }
}
