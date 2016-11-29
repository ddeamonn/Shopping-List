package lv.javaguru.java2.validator.product.rule;

import lv.javaguru.java2.data.product.ProductInputData;
import lv.javaguru.java2.validator.product.ValidationException;

import java.math.BigDecimal;

/**
 * Created by DMC on 11/28/2016.
 */
public class ProductCategoryValidatorRule implements ProductInputDataRule {
    private final static String IS_EMPTY_ERROR_MESSAGE = "Product category is mandatory";
    
    @Override
    public boolean validate(ProductInputData productData) {
        String inputCategory = productData.getInputProductCategory();
        if (inputCategory != null && !inputCategory.isEmpty()) {
            return true;
        }
        throw new ValidationException(IS_EMPTY_ERROR_MESSAGE);
    }
}
