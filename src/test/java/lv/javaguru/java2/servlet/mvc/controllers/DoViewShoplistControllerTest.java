package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.config.SpringConfig;
import lv.javaguru.java2.config.WebMVCConfig;
import lv.javaguru.java2.data.InputDataParser;
import lv.javaguru.java2.data.shoplist.ShoplistInputData;
import lv.javaguru.java2.database.ShoplistEntityDAO;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.ShoplistEntity;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.ShoplistEntityDTO;
import lv.javaguru.java2.dto.UserDTO;
import lv.javaguru.java2.dto.transformer.DataTransformer;
import lv.javaguru.java2.session.Session;
import lv.javaguru.java2.shoplist.ShoplistManager;
import lv.javaguru.java2.validator.ValidationException;
import lv.javaguru.java2.validator.shoplist.ShoplistIDValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.*;

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
public class DoViewShoplistControllerTest {

    @Autowired
    Session session;

    @Autowired
    @Qualifier("UserToDTOTransformer")
    DataTransformer<UserDTO, User> userToDTOransformer;

    @Autowired
    @Qualifier("JPAUser")
    UserDAO userDAO;

    @Autowired
    @Qualifier("UserDTOtoEntity")
    DataTransformer<User, UserDTO> userDTOToEntityTransformer;

    @Autowired
    ShoplistEntityDAO shoplistEntityDAO;

    @Autowired
    DoViewShoplistController viewController;

    @Mock
    HttpServletRequest req = mock(HttpServletRequest.class);
    HttpServletResponse resp = mock(HttpServletResponse.class);
    private HttpSession sessionHTTP = mock(HttpSession.class);

    Map<String, String[]> map;

    Long userID;
    Long shoplistID;

    @Before
    public void init() {

        userID = 142L;

        shoplistID = 117L;

        User mockUser = userDAO.getById(userID);

        UserDTO mockUserDTO = userToDTOransformer.transform(mockUser);

        session.setSessionUser(mockUserDTO);

        map = new HashMap<>();
    }

    @Test
    public void testViewRecord() throws Exception {

        prepareInputParameterData();

        Mockito.when(req.getSession()).thenReturn(sessionHTTP);
        Mockito.when(req.getParameterMap()).thenReturn(map);
        ModelAndView modelAndView = viewController.processPost(req);

        ShoplistEntityDTO entity = (ShoplistEntityDTO) (modelAndView.getModel().get("record"));

        assertEquals("viewshoppinglist", modelAndView.getViewName());
        assertTrue(entity.getShoplistID()==shoplistID);
    }

    private void  prepareInputParameterData() {

        ShoplistEntity dbShoplistEntiry = shoplistEntityDAO.getById(shoplistID);
        String orderID = dbShoplistEntiry.getShoplistID().toString();

        String key = "shoplistID";

        String[] shopListID = {orderID};
        map.put(key, shopListID);
    }
}
