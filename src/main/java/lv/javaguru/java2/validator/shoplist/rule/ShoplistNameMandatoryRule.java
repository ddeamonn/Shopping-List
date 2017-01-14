package lv.javaguru.java2.validator.shoplist.rule;

import lv.javaguru.java2.data.product.ProductInputData;
import lv.javaguru.java2.data.shoplist.ShoplistInputData;
import lv.javaguru.java2.validator.ValidationException;
import lv.javaguru.java2.validator.product.rule.ProductInputDataRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by DMC on 12/20/2016.
 */

@Component
@Qualifier("ShoplistNameMandatory")
public class ShoplistNameMandatoryRule implements ShoplistInputDataRule {

    private final static String ERROR_MESSAGE = "Shoplist name is mandatory";

    @Override
    public boolean validate(ShoplistInputData inputData) {

        if (inputData.getShoplistName() == null || inputData.getShoplistName().isEmpty()) {
            throw new ValidationException(ERROR_MESSAGE);
        }

        return true;
    }
}
