package lv.javaguru.java2.dto.transformer;

/**
 * Created by DMC on 1/13/2017.
 */
public interface DataTransformer<R, T> {
    R transform(T data);
}
