package lv.javaguru.java2.validator.product.rule;

import lv.javaguru.java2.data.product.ProductInputData;
import lv.javaguru.java2.validator.ValidationException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by DMC on 11/28/2016.
 */
@Component
@Qualifier("name")
public class ProductNameValidatorRule implements ProductInputDataRule {
    private final static String IS_EMPTY_ERROR_MESSAGE = "Product name is mandatory";
    
    @Override
    public boolean validate(ProductInputData productData) {
        if (productData.getInputProductName() != null && !productData.getInputProductName().isEmpty()) {
            return true;
        }
        throw new ValidationException(IS_EMPTY_ERROR_MESSAGE);
    }
}
