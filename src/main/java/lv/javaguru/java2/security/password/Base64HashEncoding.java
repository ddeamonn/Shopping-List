package lv.javaguru.java2.security.password;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.SecureRandom;

/**
 * Created by DMC on 1/4/2017.
 */

@Component
@Qualifier("Base64Encoding")
public class Base64HashEncoding implements PasswordEncoding {

    public final static String IS_MANDATORY_ERROR_MESSAGE = "Password.is.mandatory.";
    public final static String HAS_SALT_ERROR_MESSAGE = "The stored password has the form 'salt$hash'";

    // The higher the number of iterations the more
    // expensive computing the hash is for us and
    // also for an attacker.
    private static final int ITERATIONS = 20*1000;
    private static final int SALT_LENGTH = 32;
    private static final int DESIRED_KEY_LENGTH = 256;
    private static final String PASSWORD_SALT_DELIMITER = "$";
    private static final int PASSWORD_VALID_LENGTH = 2;

    @Override
    public String getSaltedHash(String password) throws Exception {
        byte[] salt = SecureRandom.getInstance("SHA1PRNG").generateSeed(SALT_LENGTH);
        return Base64.encodeBase64String(salt) + PASSWORD_SALT_DELIMITER + hash(password, salt);
    }

    @Override
    public boolean check(String password, String stored) throws Exception {
        String[] saltAndPass = stored.split("\\"+PASSWORD_SALT_DELIMITER);
        if (saltAndPass.length != PASSWORD_VALID_LENGTH) {
            throw new IllegalStateException(HAS_SALT_ERROR_MESSAGE);
        }

        String hashOfInput = hash(password, Base64.decodeBase64(saltAndPass[0]));
        return hashOfInput.equals(saltAndPass[1]);
    }

    private String hash(String password, byte[] salt) throws Exception {
        if (!isCorrectPassword(password))
            throw new IllegalArgumentException(IS_MANDATORY_ERROR_MESSAGE);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        SecretKey key = f.generateSecret(new PBEKeySpec(
                password.toCharArray(), salt, ITERATIONS, DESIRED_KEY_LENGTH)
        );
        return Base64.encodeBase64String(key.getEncoded());
    }

    private static boolean isCorrectPassword(String password) {
        return password != null && password.length() > 0;
    }
}
