package lv.javaguru.java2.user;

import lv.javaguru.java2.domain.User;

public class UserBuilder {

    private String userName;
    private String email;
    private String password;

    private UserBuilder() {}

    public static UserBuilder createUser() {
        return new UserBuilder();
    }

    public User build() {
        User user = new User();
        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(password);
        return user;
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
}
