package lv.javaguru.java2.authorization;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.UserDTO;
import lv.javaguru.java2.dto.transformer.DataTransformer;
import lv.javaguru.java2.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by DMC on 12/27/2016.
 */
@Component
@Qualifier("LoginAuthorisation")
public class LoginAuthorizationService implements AuthorizationService {

    @Autowired
    @Qualifier("JPAUser")
    UserDAO userDAO;

    @Autowired
    Session session;

    @Autowired
    @Qualifier("UserToDTOTransformer")
    DataTransformer<UserDTO, User> userToDTOTransformer;

    @Override
    public boolean authorize(AuthorizationContext context) {

        // TODO
        // Password and Login authorization  should be implemented here

        List<User> users = userDAO.getAll();
        User mockUser = users.get(1);


        UserDTO mockUserDTO = userToDTOTransformer.transform(mockUser);

        session.setSessionUser(mockUserDTO);

        System.out.println("Authorized " + mockUser);

        return true;
    }
}
