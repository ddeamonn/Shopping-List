package lv.javaguru.java2.servlet.mvc.controllers;
import lv.javaguru.java2.dto.ShoplistEntityDTO;
import lv.javaguru.java2.dto.UserDTO;
import lv.javaguru.java2.session.Session;
import lv.javaguru.java2.shoplist.ShoplistManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@Controller
public class ShoplistController {

    @Autowired
    ShoplistManager shoplistManager;

    @Autowired
    Session session;

    @RequestMapping(value = "", method = { RequestMethod.GET } )
    public ModelAndView processGet(HttpServletRequest req) {

        ModelAndView modelAndView;
        try {
            if (session.isLoggedUser()) {
                modelAndView = doRedirectToUserPage();
            } else {
                modelAndView = doRedirectToAuthorisationPage();
            }
        } catch (Exception exception) {
            modelAndView = doRedirectToErrorPage();
        }

        return modelAndView;
    }

    private ModelAndView doRedirectToAuthorisationPage() {
        return new ModelAndView("startpage", "login", "Welcome");
    }

    private ModelAndView doRedirectToUserPage() {
        return new ModelAndView("shoppinglist", "user", session.getSessionUser());
    }

    private ModelAndView doRedirectToErrorPage() {
        return new ModelAndView("error", "error", "Error");
    }
}
