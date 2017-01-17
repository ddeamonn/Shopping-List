package lv.javaguru.java2.user;

import lv.javaguru.java2.domain.User;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class UserBuilder {

    private Long userID;
    private String userName;
    private String email;
    private String password;
    private Timestamp addedTime;

    private UserBuilder() {}

    public static UserBuilder createUser() {
        return new UserBuilder();
    }

    public User build() {
        User user = new User();
        user.setUserID(userID);
        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(password);
        user.setAddedTime(addedTime);
        return user;
    }

    public UserBuilder withUserID(Long userID) {
        this.userID = userID;
        return this;
    }

    public UserBuilder withName(String userName) {
        this.userName = userName;
        return this;
    }

    public UserBuilder withMail(String email) {
        this.email = email;
        return this;
    }

    public UserBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserBuilder withAddedTime(Timestamp addedTime) {
        this.addedTime = addedTime;
        return this;
    }
}
