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
public class DoDeleteShoplistControllerTest {

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
    DoDeleteShoplistController deleteController;

    @Mock
    HttpServletRequest req = mock(HttpServletRequest.class);
    HttpServletResponse resp = mock(HttpServletResponse.class);
    private HttpSession sessionHTTP = mock(HttpSession.class);

    Map<String, String[]> map;

    Long userID = 142L;

    @Before
    public void init() {

        User mockUser = userDAO.getById(userID);

        UserDTO mockUserDTO = userToDTOransformer.transform(mockUser);

        session.setSessionUser(mockUserDTO);

        map = new HashMap<>();
    }

    @Test
    public void testDeleteRecord() throws Exception {

        prepareInputParameterData();

        Mockito.when(req.getSession()).thenReturn(sessionHTTP);
        Mockito.when(req.getParameterMap()).thenReturn(map);
        ModelAndView modelAndView = deleteController.processPost(req);

        String info = (String) (modelAndView.getModel().get("info"));

        assertEquals("Shopping list deleted", info);
        assertEquals("orderResult", modelAndView.getViewName());
    }

    private void  prepareInputParameterData() {

        String shoplistName = "TestDeleteShoplist";
        String productName = "Milk";
        String productQty = "1";
        String productPrice = "1.00";

        User user = userDTOToEntityTransformer.transform(session.getSessionUser());
        ShoplistEntity dbShoplistEntity = shoplistEntityDAO.getByNameAndUser(shoplistName, user);

        Long orderID;
        if (dbShoplistEntity == null) {
            ShoplistEntity newEntity = new ShoplistEntity();
            newEntity.setShoplistName(shoplistName);
            newEntity.setUser(user);
            shoplistEntityDAO.create(newEntity);

            orderID = newEntity.getShoplistID();
        } else {
            orderID = dbShoplistEntity.getShoplistID();
        }

        String inputOrderID = orderID.toString();
        String key = "shoplistID";

        String[] shopListID = {inputOrderID};
        map.put(key, shopListID);

        key = "shoplistName";
        String[] shoplistNameParam = {shoplistName};
        map.put(key, shoplistNameParam);

        key = "productName";
        String[] producttNameParam = {productName};
        map.put(key, shoplistNameParam);

        key = "productQty";
        String[] producttQtyParam = {productQty};
        map.put(key, producttQtyParam);

        key = "productPrice";
        String[] producttPriceParam = {productPrice};
        map.put(key, producttPriceParam);
    }
}
