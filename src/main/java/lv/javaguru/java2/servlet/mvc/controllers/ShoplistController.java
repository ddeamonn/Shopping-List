package lv.javaguru.java2.servlet.mvc.controllers;


import lv.javaguru.java2.domain.ShoplistEntity;
import lv.javaguru.java2.dto.ShoplistEntityDTO;
import lv.javaguru.java2.dto.UserDTO;
import lv.javaguru.java2.product.ProductManager;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import lv.javaguru.java2.servlet.mvc.ModelAndView;
import lv.javaguru.java2.session.Session;
import lv.javaguru.java2.shoplist.ShoplistManager;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;
import java.util.List;

@Component
public class ShoplistController implements MVCController {

    @Autowired
    ShoplistManager shoplistManager;

    @Autowired
    Session session;

    @Override
    public MVCModel processGet(HttpServletRequest req) {

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

        return new MVCModel(modelAndView.getView(), modelAndView.getData());
    }

    @Override
    public MVCModel processPost(HttpServletRequest req) {
       return new MVCModel("/error.jsp", "Incorrect request");
    }


    private ModelAndView doRedirectToAuthorisationPage() {
        return new ModelAndView("Welcome.", "/login.jsp");
    }

    private ModelAndView doRedirectToUserPage() {
        UserDTO userDTO = session.getSessionUser();

        Collection<ShoplistEntityDTO> shoplistEntity = shoplistManager.findUserShoplistOrders(userDTO);
        return new ModelAndView(shoplistManager.findUserShoplistOrders(userDTO), "/shoppinglist.jsp");
    }

    private ModelAndView doRedirectToErrorPage() {
        return new ModelAndView("Shoplist validation error occurred", "/error.jsp");
    }
}
