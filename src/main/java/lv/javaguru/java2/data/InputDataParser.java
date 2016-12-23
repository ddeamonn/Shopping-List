package lv.javaguru.java2.data;

import lv.javaguru.java2.data.product.ProductInputData;

import java.util.Map;

/**
 * Created by DMC on 11/28/2016.
 */
public interface InputDataParser<T, R> {
    R parse(T data);
}
