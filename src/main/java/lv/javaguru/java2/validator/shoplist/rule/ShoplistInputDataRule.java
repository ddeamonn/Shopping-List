package lv.javaguru.java2.validator.shoplist.rule;

import lv.javaguru.java2.data.product.ProductInputData;
import lv.javaguru.java2.data.shoplist.ShoplistInputData;

/**
 * Created by DMC on 11/28/2016.
 */
 public interface ShoplistInputDataRule {

    boolean validate(ShoplistInputData inputData);
}
