package lv.javaguru.java2.security.password;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by DMC on 1/4/2017.
 */
public class Base64PasswordEncodingTest {

    PasswordEncoding encoding;

    @Before
    public void init() {
        encoding = new Base64HashEncoding();
    }

    @Test
    public void validPasswordTest() throws Exception {

        PasswordEncoding encoding = new Base64HashEncoding();

        String password = "ABCD";
        String hashedPassword = encoding.getSaltedHash(password);

        boolean result = encoding.check("ABCD", hashedPassword);
        Assert.assertTrue(result);
    }

    @Test
    public void invalidPasswordTest() throws Exception {
        PasswordEncoding encoding = new Base64HashEncoding();

        String password = "ABCD";
        String hashedPassword = encoding.getSaltedHash(password);

        boolean result = encoding.check("coolhaCker", hashedPassword);
        Assert.assertFalse(result);
    }
}
