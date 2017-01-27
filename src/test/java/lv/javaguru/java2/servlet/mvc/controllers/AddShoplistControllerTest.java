package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.config.SpringConfig;
import lv.javaguru.java2.config.WebMVCConfig;
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
import lv.javaguru.java2.validator.shoplist.ShoplistInputDataValidator;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNotEquals;

/**
 * Created by DMC on 12/20/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {SpringConfig.class, WebMVCConfig.class} )
@WebAppConfiguration
public class AddShoplistControllerTest {

    private ApplicationContext springContext;

    @Autowired
    ShoplistInputDataValidator inputDataValidator;

    @Autowired
    ShoplistManager shoplistManager;

    @Autowired
    Session session;

    @Autowired
    ShoplistEntityDAO shoplistEntityDAO;

    @Autowired
    @Qualifier("UserDTOtoEntity")
    DataTransformer<User, UserDTO> userDTOToEntityTransformer;

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
    //@Transactional
    //@Rollback(false)
    public void ShoplistFieldsFilledWithDifferentNamesAndCollectDTOTest () {

        String shoplistName = "sports";
        ShoplistInputData inputData = new ShoplistInputData();
        inputData.setShoplistName("sports");

        String[] productNames = {"rollers", "volleyball"};
        inputData.setProductNames(Arrays.asList(productNames));

        String[] productQty = {"1", "2"};
        inputData.setProductQtys(Arrays.asList(productQty));

        String[] productPrices = {"0.5", "2.9"};
        inputData.setProductPrices(Arrays.asList(productPrices));

        ShoplistEntityDTO shoplistEntityDTO = shoplistManager.populateShoplistFromInputData(inputData);

        UserDTO userDTO = shoplistEntityDTO.getUserDTO();

        User user = userDTOToEntityTransformer.transform(userDTO);

        ShoplistEntity dbShoplistEntity = shoplistEntityDAO.getByNameAndUser(shoplistName, user);
        if (dbShoplistEntity != null) {
            shoplistEntityDAO.delete(dbShoplistEntity.getShoplistID());
        }

        inputDataValidator.validate(inputData);

        shoplistManager.createShoplist(shoplistEntityDTO);

        ShoplistEntity shoplistEntity = shoplistEntityDAO.getByNameAndUser(shoplistName, user);

        assertNotEquals(null, shoplistEntity);
    }

    @Test
    //@Transactional
    //@Rollback(false)
    (expected = ValidationException.class)
    public void ShoplistFieldsFilledWithSameProductNameAndCollectDTOTest () {

        String shoplistName = "sports";
        ShoplistInputData inputData = new ShoplistInputData();
        inputData.setShoplistName("sports");

        String[] productNames = {"rollers", "rollers"};
        inputData.setProductNames(Arrays.asList(productNames));

        String[] productQty = {"1", "2"};
        inputData.setProductQtys(Arrays.asList(productQty));

        String[] productPrices = {"0.5", "2.9"};
        inputData.setProductPrices(Arrays.asList(productPrices));

        inputDataValidator.validate(inputData);

        ShoplistEntityDTO shoplistEntityDTO = shoplistManager.populateShoplistFromInputData(inputData);

        UserDTO userDTO = shoplistEntityDTO.getUserDTO();

        User user = userDTOToEntityTransformer.transform(userDTO);

        ShoplistEntity dbShoplistEntity = shoplistEntityDAO.getByNameAndUser(shoplistName, user);
        if (dbShoplistEntity != null) {
            shoplistEntityDAO.delete(dbShoplistEntity.getShoplistID());
        }

        inputDataValidator.validate(inputData);

        shoplistManager.createShoplist(shoplistEntityDTO);

        ShoplistEntity shoplistEntity = shoplistEntityDAO.getByNameAndUser(shoplistName, user);

        assertNotEquals(null, shoplistEntity);
    }

}
