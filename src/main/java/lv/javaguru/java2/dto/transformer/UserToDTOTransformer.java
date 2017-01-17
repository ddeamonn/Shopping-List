package lv.javaguru.java2.dto.transformer;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.dto.UserDTO;
import lv.javaguru.java2.dto.UserDTOBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by DMC on 1/13/2017.
 */

@Component
@Qualifier("UserToDTOTransformer")
public class UserToDTOTransformer implements DataTransformer<UserDTO, User> {

    @Autowired
    UserDTOBuilder userDTOBuilder;

    @Override
    public UserDTO transform(User user) {

        UserDTO userDTO = userDTOBuilder.createUser()
                .withUserID(user.getUserID())
                .withMail(user.getEmail())
                .withPassword(user.getPassword())
                .withAddedTime(user.getAddedTime())
                .build();

        return userDTO;
    }
}
