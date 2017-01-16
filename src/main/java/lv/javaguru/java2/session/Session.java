package lv.javaguru.java2.session;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by DMC on 1/11/2017.
 */
@Component
public class Session {
    
    UserDTO sessionUser;

    public UserDTO getSessionUser() {
        return sessionUser;
    }

    public void setSessionUser(UserDTO sessionUser) {
        this.sessionUser = sessionUser;
    }

    public boolean isLoggedUser() {
        return sessionUser != null;
    }
}
