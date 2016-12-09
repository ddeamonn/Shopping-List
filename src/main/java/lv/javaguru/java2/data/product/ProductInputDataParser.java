package lv.javaguru.java2.data.product;

import lv.javaguru.java2.data.product.ProductInputData;

import java.util.Map;

/**
 * Created by DMC on 11/28/2016.
 */
public interface ProductInputDataParser {

    ProductInputData parse(Map requestMap);
}
