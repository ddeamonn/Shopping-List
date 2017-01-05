package lv.javaguru.java2.data.formatter;

/**
 * Created by DMC on 1/4/2017.
 */
public interface DataFormatter<R, T> {
    public R format(T data);
}
