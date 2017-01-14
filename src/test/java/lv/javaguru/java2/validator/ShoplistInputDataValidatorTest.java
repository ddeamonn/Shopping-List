package lv.javaguru.java2.validator;

import lv.javaguru.java2.config.SpringConfig;
import lv.javaguru.java2.data.shoplist.ShoplistInputData;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.ShoplistEntityDTO;
import lv.javaguru.java2.session.Session;
import lv.javaguru.java2.shoplist.ShoplistManager;
import lv.javaguru.java2.validator.shoplist.ShoplistInputDataValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;

/**
 * Created by DMC on 12/20/2016.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class ShoplistInputDataValidatorTest {

    private ApplicationContext springContext;

    @Autowired
    ShoplistInputDataValidator inputDataValidator;

    @Autowired
    ShoplistManager shoplistManager;

    @Autowired
    Session session;

    @Autowired
    @Qualifier("JPAUser")
    UserDAO userDAO;

    @Before
    public void init() {

        List<User> users = userDAO.getAll();
        User mockUser = users.get(0);
        session.setSessionUser(mockUser);

    }

    @Test(expected = ValidationException.class)
    public void ShoplistFieldsFilledWithoutShoplistNameTest () {
        ShoplistInputData inputData = new ShoplistInputData();
        inputData.setShoplistName("");

        String[] productNames = {"volleyball", "rollers"};
        inputData.setProductNames(Arrays.asList(productNames));

        String[] productQty = {"1", "1"};
        inputData.setProductQtys(Arrays.asList(productQty));

        inputDataValidator.validate(inputData);
    }

    @Test
    public void ShoplistFieldsFilledCorrectlyTest () {
        ShoplistInputData inputData = new ShoplistInputData();
        inputData.setShoplistName("sports");

        String[] productNames = {"volleyball", "rollers"};
        inputData.setProductNames(Arrays.asList(productNames));

        String[] productQty = {"1", "1"};
        inputData.setProductQtys(Arrays.asList(productQty));

        String[] productPrices = {"0.5", "2.9"};
        inputData.setProductPrices(Arrays.asList(productPrices));

        inputDataValidator.validate(inputData);
    }


    @Test(expected = ValidationException.class)
    public void ShoplistProductQtyLenExceedTest () {
        ShoplistInputData inputData = new ShoplistInputData();
        inputData.setShoplistName("sports");

        String[] productNames = {"volleyball", "rollers"};
        inputData.setProductNames(Arrays.asList(productNames));

        String[] productQty = {"1", "11111111"};
        inputData.setProductQtys(Arrays.asList(productQty));

        inputDataValidator.validate(inputData);
    }

    @Test(expected = ValidationException.class)
    public void ShoplistProductNameLenExceedTest () {
        ShoplistInputData inputData = new ShoplistInputData();
        inputData.setShoplistName("sports");

        String productName = "volleyballvolleyballvolleyballvolleyballvolleyball"
                + "volleyballvolleyballvolleyballvolleyballvolleyballvolleyball"
                + "volleyballvolleyballvolleyballvolleyballvolleyball";

        String[] productNames = {productName, "rollers"};
        inputData.setProductNames(Arrays.asList(productNames));

        String[] productQty = {"1", "1"};
        inputData.setProductQtys(Arrays.asList(productQty));

        inputDataValidator.validate(inputData);
    }

    @Test(expected = ValidationException.class)
    public void ShoplistNameLenExceedTest () {
        ShoplistInputData inputData = new ShoplistInputData();

        String shoplistName = "sportssportssportssportssportssportssportssportssports"
                + "sportssportssportssportssportssportssportssportssportssportssports"
                + "sportssportssportssportssportssports";
        inputData.setShoplistName(shoplistName);

        String[] productNames = {"volleyball", "rollers"};
        inputData.setProductNames(Arrays.asList(productNames));

        String[] productQty = {"1", "11111111"};
        inputData.setProductQtys(Arrays.asList(productQty));

        inputDataValidator.validate(inputData);
    }

}
