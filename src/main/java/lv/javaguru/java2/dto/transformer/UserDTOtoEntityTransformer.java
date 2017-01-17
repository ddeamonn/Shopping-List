package lv.javaguru.java2.dto.transformer;

import lv.javaguru.java2.dto.UserDTO;
import lv.javaguru.java2.user.UserBuilder;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by DMC on 1/13/2017.
 */

@Component
@Qualifier("UserDTOtoEntity")
public class UserDTOtoEntityTransformer implements DataTransformer<User, UserDTO> {

    @Autowired
    UserBuilder userBuilder;

    @Override
    public User transform(UserDTO userDTO) {

        User user = userBuilder.createUser()
                .withUserID(userDTO.getUserID())
                .withMail(userDTO.getEmail())
                .withPassword(userDTO.getPassword())
                .withAddedTime(userDTO.getAddedTime())
                .build();

        System.out.println(user.getUserID()+" "+userDTO.getUserID());
        return user;
    }
}
