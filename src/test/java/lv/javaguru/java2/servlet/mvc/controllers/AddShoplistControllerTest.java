package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.config.SpringConfig;
import lv.javaguru.java2.data.formatter.DataFormatter;
import lv.javaguru.java2.data.shoplist.ShoplistInputData;
import lv.javaguru.java2.database.ShoplistEntityDAO;
import lv.javaguru.java2.domain.ShoplistEntity;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.ShoplistEntityDTO;
import lv.javaguru.java2.dto.UserDTO;
import lv.javaguru.java2.dto.transformer.DataTranformer;
import lv.javaguru.java2.session.Session;
import lv.javaguru.java2.shoplist.ShoplistManager;
import lv.javaguru.java2.validator.ValidationException;
import lv.javaguru.java2.validator.shoplist.ShoplistInputDataValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;

import static org.junit.Assert.assertNotEquals;

/**
 * Created by DMC on 12/20/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
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
    DataTranformer<User, UserDTO> userDTOToEntityTransformer;

    @Before
    public void init() {
        UserDTO userDTO = new UserDTO();
        userDTO.setUserID(7L);
        userDTO.setUserName("User");
        session.setSessionUser(userDTO);
    }

    @Test
    //@Transactional
    //@Rollback(false)
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
