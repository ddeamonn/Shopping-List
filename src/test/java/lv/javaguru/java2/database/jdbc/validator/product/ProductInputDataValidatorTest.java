package lv.javaguru.java2.database.jdbc.validator.product;

import lv.javaguru.java2.data.product.ProductInputData;
import lv.javaguru.java2.validator.product.ProductInputDataValidator;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

/**
 * Created by DMC on 11/28/2016.
 */
public class ProductInputDataValidatorTest {

    @Test(expected = RuntimeException.class)
    public void ProductNameIsEmptyTest () {

        ProductInputData inputData = new ProductInputData();
        inputData.setProductName("");

        ProductInputDataValidator productDataValidator = new ProductInputDataValidator();
        productDataValidator.validate(inputData);
    }

    @Test(expected = RuntimeException.class)
    public void ProductNameIsNULLTest () {

        ProductInputData inputData = new ProductInputData();
        inputData.setProductName(null);

        ProductInputDataValidator productDataValidator = new ProductInputDataValidator();
        productDataValidator.validate(inputData);
    }

    @Test
    public void ProductNameIsSpecifiedTest () {

        ProductInputData inputData = new ProductInputData();
        inputData.setProductName("Milk");

        ProductInputDataValidator productDataValidator = new ProductInputDataValidator();
        boolean result = productDataValidator.validate(inputData);

        assertTrue(result);
    }
}
