package lv.javaguru.java2.validator.product;

import lv.javaguru.java2.validator.product.rule.ProductCategoryValidatorRule;
import lv.javaguru.java2.validator.product.rule.ProductInputDataRule;
import lv.javaguru.java2.validator.product.rule.ProductNameValidatorRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DMC on 11/30/2016.
 */
@Component
public class ProductRuleFactory {

    @Autowired
    List<ProductInputDataRule>  rules;

    public List<ProductInputDataRule> getProductInputRules() {
        return rules;
    }
}
