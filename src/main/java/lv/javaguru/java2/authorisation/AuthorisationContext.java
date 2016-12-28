package lv.javaguru.java2.authorisation;

/**
 * Created by DMC on 12/27/2016.
 */
public class AuthorisationContext {
    String login;
    String password;
    String hashNumber;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHashNumber() {
        return hashNumber;
    }

    public void setHashNumber(String hashNumber) {
        this.hashNumber = hashNumber;
    }
}
