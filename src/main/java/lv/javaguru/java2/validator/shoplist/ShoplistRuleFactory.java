package lv.javaguru.java2.validator.shoplist;

import lv.javaguru.java2.validator.product.rule.ProductCategoryValidatorRule;
import lv.javaguru.java2.validator.product.rule.ProductInputDataRule;
import lv.javaguru.java2.validator.product.rule.ProductNameValidatorRule;
import lv.javaguru.java2.validator.shoplist.rule.ShoplistInputDataRule;
import lv.javaguru.java2.validator.shoplist.rule.ShoplistProductNameRule;
import lv.javaguru.java2.validator.shoplist.rule.ShoplistQtyRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DMC on 11/30/2016.
 */

@Component
public class ShoplistRuleFactory {

    @Autowired
    private List<ShoplistInputDataRule> rules;

    public List<ShoplistInputDataRule> getShoplistRules() {
        return rules;
    }
}
