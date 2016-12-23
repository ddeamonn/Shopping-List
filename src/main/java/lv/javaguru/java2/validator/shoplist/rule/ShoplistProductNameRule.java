package lv.javaguru.java2.validator.shoplist.rule;

import lv.javaguru.java2.data.product.ProductInputData;
import lv.javaguru.java2.data.shoplist.ShoplistInputData;
import lv.javaguru.java2.validator.product.rule.ProductInputDataRule;
import lv.javaguru.java2.validator.product.rule.ProductNameValidatorRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by DMC on 12/20/2016.
 */

@Component
@Qualifier("shopProductName")
public class ShoplistProductNameRule implements ShoplistInputDataRule {

    @Autowired
    ProductInputData productInputData;

    @Autowired
    @Qualifier("name")
    ProductInputDataRule productNameRule;

    @Override
    public boolean validate(ShoplistInputData inputData) {
        Collection<String> nameOfProducts = inputData.getProductNames();

        for (String productName : nameOfProducts) {
            productInputData.setInputProductName(productName);
            productNameRule.validate(productInputData);
        }

        return true;
    }
}
