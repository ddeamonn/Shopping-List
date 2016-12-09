package lv.javaguru.java2.domain;

public class UserBuilder {

    private String userName;

    private UserBuilder() {}

    public static UserBuilder createUser() {
        return new UserBuilder();
    }

    public User build() {
        User user = new User();
        user.setUserName(userName);
        return user;
    }

    public UserBuilder withName(String userName) {
        this.userName = userName;
        return this;
    }
}
