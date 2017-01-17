package lv.javaguru.java2.dto;

import lv.javaguru.java2.domain.ShoplistEntity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collection;

public class UserDTO {

    private Long userID;

    private String userName;

    private String hashCode;

    private String email;

    private String password;

    private String phone;

    private String language;

    private Timestamp addedTime;

    private Collection<ShoplistEntityDTO> shoplistEntities = new ArrayList<>();

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

    public Collection<ShoplistEntityDTO> getShoplistEntities() {
        return shoplistEntities;
    }

    public void setShoplistEntities(Collection<ShoplistEntityDTO> shoplistEntities) {
        this.shoplistEntities = shoplistEntities;
    }

    public Timestamp getAddedTime() {
        return addedTime;
    }

    public void setAddedTime(Timestamp addedTime) {
        this.addedTime = addedTime;
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
                ", shoplistEntities=" + shoplistEntities.size() +
                '}';
    }
}
