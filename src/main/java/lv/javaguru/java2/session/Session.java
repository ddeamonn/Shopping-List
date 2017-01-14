package lv.javaguru.java2.session;

import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by DMC on 1/11/2017.
 */
@Component
public class Session {
    
    User sessionUser;

    public User getSessionUser() {
        return sessionUser;
    }

    public void setSessionUser(User sessionUser) {
        this.sessionUser = sessionUser;
    }

    public boolean isLoggedUser() {
        return sessionUser != null;
    }
}
