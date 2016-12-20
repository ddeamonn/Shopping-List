package lv.javaguru.java2.validator.shoplist.rule;

import lv.javaguru.java2.data.product.ProductInputData;
import lv.javaguru.java2.data.shoplist.ShoplistInputData;
import lv.javaguru.java2.validator.ValidationException;
import lv.javaguru.java2.validator.product.rule.ProductInputDataRule;
import lv.javaguru.java2.validator.product.rule.ProductNameValidatorRule;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * Created by DMC on 12/20/2016.
 */
@Component
@Qualifier("shopProductQty")
public class ShoplistQtyRule implements ShoplistInputDataRule {

    @Override
    public boolean validate(ShoplistInputData inputData) {
        Collection<String> qtyOfProducts = inputData.getProductQtys();
        try {
            for (String qtyProduct : qtyOfProducts) {
                Integer parsedQtyProduct = Integer.parseInt(qtyProduct);
            }
        } catch (Exception exception) {
            throw new ValidationException(exception.getMessage());
        }

        return true;
    }
}
