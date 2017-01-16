package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.config.SpringConfig;
import lv.javaguru.java2.domain.ShoplistEntity;
import lv.javaguru.java2.dto.ShoplistEntityDTO;
import lv.javaguru.java2.dto.UserDTO;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import lv.javaguru.java2.servlet.mvc.ModelAndView;
import lv.javaguru.java2.session.Session;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

/**
 * Created by DMC on 1/16/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class ShoplistControllerTest {

    @Autowired
    Session session;

    HttpServletRequest req;

    @Autowired
    ShoplistController controller;

    @Before
    public void init() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserID(7L);
        userDTO.setUserName("User");

        session.setSessionUser(userDTO);
    }

    @Test
    public void userLoggedInTest () {
        MVCModel modelAndView = controller.processGet(req);

        Object data  = modelAndView.getData();
        String view = modelAndView.getJspName();

        assertEquals("/shoppinglist.jsp", view);
    }
}
