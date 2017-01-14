package lv.javaguru.java2.validator.shoplist.rule;

import lv.javaguru.java2.data.shoplist.ShoplistInputData;
import lv.javaguru.java2.validator.ValidationException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collection;

/**
 * Created by DMC on 12/20/2016.
 */

@Component
@Qualifier("ShoplistProductNameLength")
public class ShoplistProductQtyLengthRule implements ShoplistInputDataRule {

    private final static String ERROR_MESSAGE = "Product quantity incorrect length";
    private final static int MAX_LENGTH = 3;

    @Override
    public boolean validate(ShoplistInputData inputData) {
        Collection<String> qtyOfProducts = inputData.getProductQtys();

        for (String productQty : qtyOfProducts) {
            if (productQty.length() > MAX_LENGTH) {
                throw new ValidationException(ERROR_MESSAGE);
            }
        }

        return true;
    }
}
