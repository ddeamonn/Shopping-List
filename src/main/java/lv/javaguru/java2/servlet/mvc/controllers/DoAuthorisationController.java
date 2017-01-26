package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.authorization.AuthorizationContext;
import lv.javaguru.java2.authorization.AuthorizationService;
import lv.javaguru.java2.dto.UserDTO;
import lv.javaguru.java2.session.Session;
import lv.javaguru.java2.shoplist.ShoplistManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

//import lv.javaguru.java2.servlet.mvc.ModelAndView;

/**
 * Created by DMC on 1/4/2017.
 */

@Controller
public class DoAuthorisationController {

    @Autowired
    @Qualifier("LoginAuthorisation")
    AuthorizationService authorisation;

    @Autowired
    Session session;

    @Autowired
    ShoplistManager shoplistManager;

    @RequestMapping(value =  "doLogging", method = {RequestMethod.POST} )
    public ModelAndView processPost(HttpServletRequest req) {

        AuthorizationContext context = new AuthorizationContext();
        context.setHashNumber("123344");
        authorisation.authorize(context);

        return  doRedirectToUserPage();

    }
/*
    @RequestMapping(value =  "doLogging", method = {RequestMethod.POST} )
    public MVCModel processGet(HttpServletRequest req) {
        return new MVCModel("/error.jsp", "Incorrect request");
    }
*/
    private ModelAndView doRedirectToUserPage() {

        UserDTO userDTO = session.getSessionUser();
        return new ModelAndView("shoppinglist", "orders", shoplistManager.findUserShoplistOrders(userDTO) );
    }
}
