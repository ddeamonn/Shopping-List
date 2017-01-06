package lv.javaguru.java2.registration;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by DMC on 1/4/2017.
 */
@Component
public class Registration {

    @Autowired
    @Qualifier("JPAUser")
    private UserDAO userDAO;

    public boolean register(User user) {
        userDAO.create(user);
        return true;
    }
}
