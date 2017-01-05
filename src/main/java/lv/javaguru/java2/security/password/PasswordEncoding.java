package lv.javaguru.java2.security.password;

/**
 * Created by DMC on 1/4/2017.
 */
public interface PasswordEncoding {

    String getSaltedHash(String password) throws Exception;
    boolean check(String password, String stored) throws Exception;
}
