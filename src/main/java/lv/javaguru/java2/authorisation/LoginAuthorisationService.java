package lv.javaguru.java2.authorisation;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.UserDTO;
import lv.javaguru.java2.dto.transformer.DataTranformer;
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
public class LoginAuthorisationService implements AuthorisationService {

    @Autowired
    @Qualifier("JPAUser")
    UserDAO userDAO;

    @Autowired
    Session session;

    @Autowired
    @Qualifier("UserToDTOTransformer")
    DataTranformer<UserDTO, User> userToDTOTransformer;

    @Override
    public boolean authorise(AuthorisationContext context) {

        // TODO
        // Password and Login Autorisation  should be implemented here

        List<User> users = userDAO.getAll();
        User mockUser = users.get(1);


        UserDTO mockUserDTO = userToDTOTransformer.transform(mockUser);

        session.setSessionUser(mockUserDTO);

        System.out.println("Authorised " + mockUser);

        return true;
    }
}
