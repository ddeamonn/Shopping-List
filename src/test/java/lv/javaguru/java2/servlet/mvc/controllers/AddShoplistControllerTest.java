package lv.javaguru.java2.servlet.mvc.controllers;

import lv.javaguru.java2.config.SpringConfig;
import lv.javaguru.java2.data.shoplist.ShoplistInputData;
import lv.javaguru.java2.domain.ShoplistEntity;
import lv.javaguru.java2.shoplist.ShoplistManager;
import lv.javaguru.java2.validator.shoplist.ShoplistInputDataValidator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by DMC on 12/20/2016.
 */

public class AddShoplistControllerTest {

    private ApplicationContext springContext;

    @Autowired
    ShoplistInputDataValidator inputDataValidator;

    @Autowired
    ShoplistManager shoplistManager;

    @Before
    public void init() {
        try {
            springContext = new AnnotationConfigApplicationContext(SpringConfig.class);
            inputDataValidator =
                    (ShoplistInputDataValidator)springContext.getBean(ShoplistInputDataValidator.class);
            shoplistManager =
                    (ShoplistManager)springContext.getBean(ShoplistManager.class);
        } catch (BeansException e) {
            System.out.println("error"+e.getMessage());
        }
    }

    @Test
    public void ShoplistFieldsFilledCorrectlyTest () {
        ShoplistInputData inputData = new ShoplistInputData();
        inputData.setShoplistName("sports");

        String[] productNames = {"volleyball", "rollers"};
        inputData.setProductNames(Arrays.asList(productNames));

        String[] productQty = {"1", "1"};
        inputData.setProductQtys(Arrays.asList(productQty));

        inputDataValidator.validate(inputData);

        ShoplistEntity shoplistEntity = shoplistManager.populateShoplistFromInputData(inputData);

        Assert.assertEquals("sports", shoplistEntity.getShoplistName());
    }
}
