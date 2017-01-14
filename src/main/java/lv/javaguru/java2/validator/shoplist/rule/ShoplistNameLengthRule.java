package lv.javaguru.java2.validator.shoplist.rule;

import lv.javaguru.java2.data.shoplist.ShoplistInputData;
import lv.javaguru.java2.validator.ValidationException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by DMC on 12/20/2016.
 */

@Component
@Qualifier("ShoplistNameLength")
public class ShoplistNameLengthRule implements ShoplistInputDataRule {

    private final static String ERROR_MESSAGE = "Shoplist name incorrect length";
    private final static int MAX_LENGTH = 45;

    @Override
    public boolean validate(ShoplistInputData inputData) {

        if (inputData.getShoplistName().length() > MAX_LENGTH) {
            throw new ValidationException(ERROR_MESSAGE);
        }

        return true;
    }
}
