package lv.javaguru.java2.validator.shoplist;

import lv.javaguru.java2.data.product.ProductInputData;
import lv.javaguru.java2.data.shoplist.ShoplistInputData;
import lv.javaguru.java2.validator.product.ProductRuleFactory;
import lv.javaguru.java2.validator.product.rule.ProductInputDataRule;
import lv.javaguru.java2.validator.shoplist.rule.ShoplistInputDataRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by DMC on 11/28/2016.
 */
@Component
public class ShoplistInputDataValidator {

    @Autowired
    private ShoplistRuleFactory ruleFactory;

    public boolean validate(ShoplistInputData inputData) {

        List<ShoplistInputDataRule> rules = ruleFactory.getShoplistRules();

        for (ShoplistInputDataRule rule : rules) {
            rule.validate(inputData);
        }
        return true;
    }
}
