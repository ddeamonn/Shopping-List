package lv.javaguru.java2.validator.product.rule;

import lv.javaguru.java2.data.product.ProductInputData;
import lv.javaguru.java2.validator.product.rule.ProductInputDataRule;

/**
 * Created by DMC on 11/28/2016.
 */
public class ProductNameValidatorRule implements ProductInputDataRule {
    final String IS_EMPTY_ERROR_MESSAGE = "Product name is mandatory";
    
    @Override
    public boolean validate(ProductInputData productData) {
        if (productData.getProductName() != null && !productData.getProductName().isEmpty()) {
            return true;
        }
        throw new RuntimeException(IS_EMPTY_ERROR_MESSAGE);
    }
}
