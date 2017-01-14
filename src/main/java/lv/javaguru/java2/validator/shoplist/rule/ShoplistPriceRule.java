package lv.javaguru.java2.validator.shoplist.rule;

import lv.javaguru.java2.data.shoplist.ShoplistInputData;
import lv.javaguru.java2.validator.ValidationException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Collection;

/**
 * Created by DMC on 12/20/2016.
 */
@Component
@Qualifier("shopProductQty")
public class ShoplistPriceRule implements ShoplistInputDataRule {
    private final static String ERROR_MESSAGE = "Incorrect price format";

    @Override
    public boolean validate(ShoplistInputData inputData) {
        Collection<String> priceOfProducts = inputData.getProductPrices();
        try {
            for (String priceProduct : priceOfProducts) {
                BigDecimal parsedPriceProduct = new BigDecimal(priceProduct);
            }
        } catch (Exception exception) {
            throw new ValidationException(ERROR_MESSAGE);
        }

        return true;
    }
}
