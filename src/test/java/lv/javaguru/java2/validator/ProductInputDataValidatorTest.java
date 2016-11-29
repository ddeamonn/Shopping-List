package lv.javaguru.java2.validator;

import lv.javaguru.java2.data.product.ProductInputData;
import lv.javaguru.java2.validator.product.ProductInputDataValidator;
import lv.javaguru.java2.validator.product.ValidationException;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by DMC on 11/28/2016.
 */
public class ProductInputDataValidatorTest {

    @Test(expected = ValidationException.class)
    public void ProductNameIsEmptyTest () {

        ProductInputData inputData = new ProductInputData();
        inputData.setInputProductName("");
        inputData.setInputProductCategory("Food");

        ProductInputDataValidator productDataValidator = new ProductInputDataValidator();
        productDataValidator.prepareRules();

        productDataValidator.validate(inputData);
    }

    @Test(expected = ValidationException.class)
    public void ProductNameIsNULLTest () {

        ProductInputData inputData = new ProductInputData();
        inputData.setInputProductName(null);
        inputData.setInputProductCategory("Food");

        ProductInputDataValidator productDataValidator = new ProductInputDataValidator();
        productDataValidator.prepareRules();

        productDataValidator.validate(inputData);
    }

    @Test
    public void ProductNameIsSpecifiedTest () {

        ProductInputData inputData = new ProductInputData();
        inputData.setInputProductName("Milk");
        inputData.setInputProductCategory("Food");

        ProductInputDataValidator productDataValidator = new ProductInputDataValidator();
        productDataValidator.prepareRules();

        boolean result = productDataValidator.validate(inputData);

        assertTrue(result);
    }
}
