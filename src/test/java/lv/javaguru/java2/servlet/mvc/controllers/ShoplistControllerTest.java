package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.config.SpringConfig;
import lv.javaguru.java2.config.WebMVCConfig;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.UserDTO;
import lv.javaguru.java2.dto.transformer.DataTransformer;
import lv.javaguru.java2.session.Session;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by DMC on 1/16/2017.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class, WebMVCConfig.class} )
@WebAppConfiguration
public class ShoplistControllerTest {

    @Autowired
    Session session;

    HttpServletRequest req;

    @Autowired
    ShoplistController controller;

    @Autowired
    @Qualifier("JPAUser")
    UserDAO userDAO;

    @Autowired
    @Qualifier("UserToDTOTransformer")
    DataTransformer<UserDTO, User> userToDTOransformer;

    @Before
    public void init() {
        List<User> users = userDAO.getAll();
        User mockUser = users.get(0);

        UserDTO mockUserDTO = userToDTOransformer.transform(mockUser);

        session.setSessionUser(mockUserDTO);
    }

    @Test
    public void userLoggedInTest () {
        ModelAndView modelAndView = controller.processGet(req);

        assertEquals("shoppinglist", modelAndView.getViewName());
    }
}
