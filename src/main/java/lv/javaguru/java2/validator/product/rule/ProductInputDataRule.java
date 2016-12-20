package lv.javaguru.java2.validator.product.rule;

import lv.javaguru.java2.data.product.ProductInputData;
import org.springframework.stereotype.Component;

/**
 * Created by DMC on 11/28/2016.
 */

 public interface ProductInputDataRule {

    boolean validate(ProductInputData productData);
}
