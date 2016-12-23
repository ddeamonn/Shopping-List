package lv.javaguru.java2.validator;

import lv.javaguru.java2.config.SpringConfig;
import lv.javaguru.java2.data.product.ProductInputData;
import lv.javaguru.java2.shoplist.ShoplistManager;
import lv.javaguru.java2.validator.product.ProductInputDataValidator;
import lv.javaguru.java2.validator.shoplist.ShoplistInputDataValidator;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.assertTrue;

/**
 * Created by DMC on 11/28/2016.
 */
public class ProductInputDataValidatorTest {

    private ApplicationContext springContext;

    @Autowired
    ProductInputDataValidator inputDataValidator;

    @Autowired
    ShoplistManager shoplistManager;

    @Before
    public void init() {
        try {
            springContext = new AnnotationConfigApplicationContext(SpringConfig.class);
            inputDataValidator =
                    (ProductInputDataValidator)springContext.getBean(ProductInputDataValidator.class);
            shoplistManager =
                    (ShoplistManager)springContext.getBean(ShoplistManager.class);
        } catch (BeansException e) {
            System.out.println("error"+e.getMessage());
        }
    }

    @Test(expected = ValidationException.class)
    public void ProductNameIsEmptyTest () {

        ProductInputData inputData = new ProductInputData();
        inputData.setInputProductName("");
        inputData.setInputProductCategory("Food");

        //ProductInputDataValidator productDataValidator = new ProductInputDataValidator();
        inputDataValidator.validate(inputData);

    }

    @Test(expected = ValidationException.class)
    public void ProductNameIsNULLTest () {

        ProductInputData inputData = new ProductInputData();
        inputData.setInputProductName(null);
        inputData.setInputProductCategory("Food");

        //ProductInputDataValidator productDataValidator = new ProductInputDataValidator();
        inputDataValidator.validate(inputData);
    }

    @Test
    public void ProductNameIsSpecifiedTest () {

        ProductInputData inputData = new ProductInputData();
        inputData.setInputProductName("Milk");
        inputData.setInputProductCategory("Food");

        //ProductInputDataValidator productDataValidator = new ProductInputDataValidator();

        boolean result = inputDataValidator.validate(inputData);

        assertTrue(result);
    }
}
