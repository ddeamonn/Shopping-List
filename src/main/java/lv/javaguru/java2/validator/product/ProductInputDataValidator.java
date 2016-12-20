package lv.javaguru.java2.validator.product;

import lv.javaguru.java2.data.product.ProductInputData;
import lv.javaguru.java2.validator.product.rule.ProductCategoryValidatorRule;
import lv.javaguru.java2.validator.product.rule.ProductInputDataRule;
import lv.javaguru.java2.validator.product.rule.ProductNameValidatorRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DMC on 11/28/2016.
 */
@Component
public class ProductInputDataValidator {

    @Autowired
    ProductRuleFactory productRuleFactory;

    public boolean validate(ProductInputData inputData) {

        List<ProductInputDataRule> rules = productRuleFactory.getProductInputRules();

        for (ProductInputDataRule rule : rules) {
            rule.validate(inputData);
        }
        return true;
    }
}
