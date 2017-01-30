package lv.javaguru.java2.servlet.mvc.controllers;
import lv.javaguru.java2.dto.UserDTO;
import lv.javaguru.java2.session.Session;
import lv.javaguru.java2.shoplist.ShoplistManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DoViewShoplistsController {

    @Autowired
    ShoplistManager shoplistManager;

    @Autowired
    Session session;

    @RequestMapping(value = "doViewshoplists", method = { RequestMethod.GET } )
    public ModelAndView processGet(HttpServletRequest req) {

        ModelAndView modelAndView;
        try {
            modelAndView = doRedirectToUserPage();
        } catch (Exception exception) {
            modelAndView = doRedirectToErrorPage();
        }

        return modelAndView;
    }

    private ModelAndView doRedirectToUserPage() {
        UserDTO userDTO = session.getSessionUser();
        return new ModelAndView("viewshoplists", "orders", shoplistManager.findUserShoplistOrders(userDTO));
    }

    private ModelAndView doRedirectToErrorPage() {
        return new ModelAndView("error", "error", "Error");
    }
}
