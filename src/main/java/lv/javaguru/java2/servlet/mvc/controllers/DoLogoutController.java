package lv.javaguru.java2.servlet.mvc.controllers;


import lv.javaguru.java2.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class DoLogoutController {

    @Autowired
    Session session;

    @RequestMapping(value = "doLogout", method = { RequestMethod.GET } )
    public ModelAndView processGet(HttpServletRequest req) {
        logout(req);
        return doRedirectToLogoutResultPage();
    }

    private ModelAndView doRedirectToLogoutResultPage() {
        return new ModelAndView("logout","info",null);
    }

    private void logout(HttpServletRequest req) {
        session.setSessionUser(null);
        req.getSession().invalidate();
    }

}
