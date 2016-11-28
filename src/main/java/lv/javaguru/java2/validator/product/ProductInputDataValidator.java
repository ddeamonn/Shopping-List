package lv.javaguru.java2.validator.product;

import lv.javaguru.java2.data.product.ProductInputData;
import lv.javaguru.java2.validator.product.rule.ProductInputDataRule;
import lv.javaguru.java2.validator.product.rule.ProductNameValidatorRule;

/**
 * Created by DMC on 11/28/2016.
 */
public class ProductInputDataValidator {

    public boolean validate(ProductInputData inputData) {
        ProductInputDataRule rule = new ProductNameValidatorRule();
        rule.validate(inputData);
        return true;
    }
}
