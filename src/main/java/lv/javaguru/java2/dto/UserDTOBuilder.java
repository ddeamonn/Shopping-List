package lv.javaguru.java2.dto;

import lv.javaguru.java2.domain.User;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

@Component
public class UserDTOBuilder {

    private Long userID;
    private String userName;
    private String email;
    private String password;
    private Timestamp addedTime;

    private UserDTOBuilder() {}

    public static UserDTOBuilder createUser() {
        return new UserDTOBuilder();
    }

    public UserDTO build() {
        UserDTO user = new UserDTO();
        user.setUserID(userID);
        user.setUserName(userName);
        user.setEmail(email);
        user.setPassword(password);
        user.setAddedTime(addedTime);
        return user;
    }

    public UserDTOBuilder withUserID(Long userID) {
        this.userID = userID;
        return this;
    }

    public UserDTOBuilder withName(String userName) {
        this.userName = userName;
        return this;
    }

    public UserDTOBuilder withMail(String email) {
        this.email = email;
        return this;
    }

    public UserDTOBuilder withPassword(String password) {
        this.password = password;
        return this;
    }

    public UserDTOBuilder withAddedTime(Timestamp addedTime) {
        this.addedTime = addedTime;
        return this;
    }
}
