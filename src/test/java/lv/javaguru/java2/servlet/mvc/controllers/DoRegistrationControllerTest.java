package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.config.SpringConfig;
import lv.javaguru.java2.config.WebMVCConfig;
import lv.javaguru.java2.database.ShoplistEntityDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.ShoplistEntity;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.ShoplistEntityDTO;
import lv.javaguru.java2.dto.UserDTO;
import lv.javaguru.java2.dto.transformer.DataTransformer;
import lv.javaguru.java2.session.Session;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * Created by DMC on 1/4/2017.
 */

@Controller
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class,WebMVCConfig.class})
@WebAppConfiguration
public class DoRegistrationControllerTest {

    @Autowired
    Session session;

    @Autowired
    DoRegistrationController registrationController;

    @Autowired
    @Qualifier("JPAUser")
    UserDAO userDAO;

    @Mock
    HttpServletRequest req = mock(HttpServletRequest.class);
    HttpServletResponse resp = mock(HttpServletResponse.class);
    private HttpSession sessionHTTP = mock(HttpSession.class);

    Map<String, String[]> map;

    @Before
    public void init() {
        map = new HashMap<>();
    }

    @Test
    public void testNewUserRegistered() throws Exception {

        prepareInputParameterData();

        Mockito.when(req.getSession()).thenReturn(sessionHTTP);
        Mockito.when(req.getParameterMap()).thenReturn(map);
        ModelAndView modelAndView = registrationController.processPost(req);

        String info = (String) (modelAndView.getModel().get("info"));

        assertEquals("User registered", info);
        assertEquals("registrationResult", modelAndView.getViewName());
    }

    private void  prepareInputParameterData() {

        String key = "customerMail";
        String[] mail = {"newmail@mail.com"};
        map.put(key, mail);

        key = "repeatCustomerMail";
        String[] repeatmail = {"newmail@mail.com"};
        map.put(key, repeatmail);

        key = "customerPassword";
        String[] password = {"1234"};
        map.put(key, password);

        key = "repeatCustomerPassword";
        String[] repeatPassword = {"1234"};
        map.put(key, repeatPassword);

        User dbUser = userDAO.getUserByEmail("newmail@mail.com");

        if (dbUser != null) {
            userDAO.delete(dbUser.getUserID());
        }
    }
}
