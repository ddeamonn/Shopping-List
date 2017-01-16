package lv.javaguru.java2.validator.shoplist.rule;

import lv.javaguru.java2.data.shoplist.ShoplistInputData;
import lv.javaguru.java2.validator.ValidationException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by DMC on 12/20/2016.
 */

@Component
@Qualifier("ShoplistIDRule")
public class ShoplistIDRule {

    private final static String ERROR_MESSAGE = "Incorrect shoplist ID";

    public boolean validate(ShoplistInputData inputData) {

        try {
            System.out.println("Validator"+inputData.getShoplistID());
            Long parsedshoplistID = Long.parseLong(inputData.getShoplistID());
        } catch (Exception exception) {
            throw new ValidationException(ERROR_MESSAGE);
        }

        return true;
    }
}
