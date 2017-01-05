package lv.javaguru.java2.validator.register.rule;

import lv.javaguru.java2.data.registration.RegistrationInputData;
import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.validator.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.persistence.NoResultException;

/**
 * Created by DMC on 1/4/2017.
 */
@Component
@Qualifier("UniqueUserRule")
public class UniqueUserEmailRule implements RegistrationInputDataRule {

    private final static String ERROR_MESSAGE = "User already registered";

    @Autowired
    @Qualifier("JPAUser")
    UserDAO userDAO;

    @Override
    public boolean validate(RegistrationInputData registrationData) {

        try {
            String email = registrationData.getEmail();
            User user = userDAO.getUserByEmail(email);
            if (user == null ){
                return true;
            }
        } catch (NoResultException nre) {
            return true;
        }

        throw new ValidationException(ERROR_MESSAGE);
    }
}
