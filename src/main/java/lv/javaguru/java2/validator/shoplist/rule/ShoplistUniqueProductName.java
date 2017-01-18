package lv.javaguru.java2.validator.shoplist.rule;

import lv.javaguru.java2.data.product.ProductInputData;
import lv.javaguru.java2.data.shoplist.ShoplistInputData;
import lv.javaguru.java2.validator.ValidationException;
import lv.javaguru.java2.validator.product.rule.ProductInputDataRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by DMC on 12/20/2016.
 */

@Component
@Qualifier("shopProductUniqueName")
public class ShoplistUniqueProductName implements ShoplistInputDataRule {

    private final static String ERROR_MESSAGE = "Same product name";

    @Autowired
    ProductInputData productInputData;

    @Autowired
    @Qualifier("name")
    ProductInputDataRule productNameRule;

    @Override
    public boolean validate(ShoplistInputData inputData) {
        Collection<String> nameOfProducts = inputData.getProductNames();
        Set<String> nameOfProductSet = new HashSet<String>(nameOfProducts);

        if (nameOfProducts.size() != nameOfProductSet.size()) {
            throw new ValidationException(ERROR_MESSAGE);
        }

        return nameOfProducts.size() == nameOfProductSet.size();
    }
}
