package lv.javaguru.java2.validator.product;

import lv.javaguru.java2.data.product.ProductInputData;
import lv.javaguru.java2.validator.product.rule.ProductCategoryValidatorRule;
import lv.javaguru.java2.validator.product.rule.ProductInputDataRule;
import lv.javaguru.java2.validator.product.rule.ProductNameValidatorRule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DMC on 11/28/2016.
 */
public class ProductInputDataValidator {

    List<ProductInputDataRule> rules;

    public void prepareRules() {

        rules = new ArrayList<>();

        ProductInputDataRule rule = new ProductNameValidatorRule();
        rules.add(rule);

        rule = new ProductCategoryValidatorRule();
        rules.add(rule);
    }

    public boolean validate(ProductInputData inputData) {

        for (ProductInputDataRule rule : rules) {
            rule.validate(inputData);
        }
        return true;
    }
}
