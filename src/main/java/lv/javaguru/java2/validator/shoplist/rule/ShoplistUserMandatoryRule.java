package lv.javaguru.java2.validator.shoplist.rule;

import lv.javaguru.java2.data.shoplist.ShoplistInputData;
import lv.javaguru.java2.session.Session;
import lv.javaguru.java2.validator.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by DMC on 12/20/2016.
 */

@Component
@Qualifier("ShoplistUserMandatory")
public class ShoplistUserMandatoryRule implements ShoplistInputDataRule {

    private final static String ERROR_MESSAGE = "No authorised user";

    @Autowired
    Session session;

    @Override
    public boolean validate(ShoplistInputData inputData) {

        if (!session.isLoggedUser()) {
            throw new ValidationException(ERROR_MESSAGE);
        }

        return true;
    }
}
