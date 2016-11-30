package lv.javaguru.java2.validator.product;

import lv.javaguru.java2.validator.product.rule.ProductCategoryValidatorRule;
import lv.javaguru.java2.validator.product.rule.ProductInputDataRule;
import lv.javaguru.java2.validator.product.rule.ProductNameValidatorRule;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DMC on 11/30/2016.
 */
public class ProductRuleFactory {

    public static List<ProductInputDataRule> getProductInputRules() {
        List<ProductInputDataRule>  rules = new ArrayList<>();

        ProductInputDataRule rule = new ProductNameValidatorRule();
        rules.add(rule);

        rule = new ProductCategoryValidatorRule();
        rules.add(rule);

        return rules;
    }
}
