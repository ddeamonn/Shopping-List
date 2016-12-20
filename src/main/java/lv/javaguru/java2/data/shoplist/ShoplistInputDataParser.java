package lv.javaguru.java2.data.shoplist;

import lv.javaguru.java2.data.product.ProductInputData;

import java.util.Map;

/**
 * Created by DMC on 11/28/2016.
 */
public interface ShoplistInputDataParser {

    ShoplistInputData parse(Map requestMap);
}
