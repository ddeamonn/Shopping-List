package lv.javaguru.java2.domain;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "usr_id", nullable = false)
    private Long userID;

    @Column(name = "usr_name", nullable = true)
    private String userName;

    @Column(name = "usr_hash", nullable = true)
    private String hashCode;

    @Column(name = "usr_email", nullable = true)
    private String email;

    @Column(name = "usr_password", nullable = true)
    private String password;

    @Column(name = "usr_phone", nullable = true)
    private String phone;

    @Column(name = "usr_language", nullable = true)
    private String language;

    @Column(name = "usr_added_time", nullable = true)
    private Timestamp addedTime;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getHashCode() {
        return hashCode;
    }

    public void setHashCode(String hashCode) {
        this.hashCode = hashCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public Timestamp getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(Timestamp addedTime) {
        this.addedTime = addedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userID != null ? !userID.equals(user.userID) : user.userID != null) return false;
        if (userName != null ? !userName.equals(user.userName) : user.userName != null) return false;
        if (hashCode != null ? !hashCode.equals(user.hashCode) : user.hashCode != null) return false;
        if (email != null ? !email.equals(user.email) : user.email != null) return false;
        if (password != null ? !password.equals(user.password) : user.password != null) return false;
        if (phone != null ? !phone.equals(user.phone) : user.phone != null) return false;
        if (language != null ? !language.equals(user.language) : user.language != null) return false;
        return addedTime != null ? addedTime.equals(user.addedTime) : user.addedTime == null;

    }

    @Override
    public int hashCode() {
        int result = userID != null ? userID.hashCode() : 0;
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (hashCode != null ? hashCode.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (language != null ? language.hashCode() : 0);
        result = 31 * result + (addedTime != null ? addedTime.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", hashCode='" + hashCode + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", phone='" + phone + '\'' +
                ", language='" + language + '\'' +
                '}';
    }
}
