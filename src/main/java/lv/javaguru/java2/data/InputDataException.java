package lv.javaguru.java2.data;

/**
 * Created by DMC on 11/29/2016.
 */
public class InputDataException extends RuntimeException {

    public InputDataException(String message) {
        super(message);
    }

    public InputDataException(String message, Throwable cause) {
        super(message, cause);
    }

    public InputDataException(Throwable cause) {
        super(cause);
    }
}
