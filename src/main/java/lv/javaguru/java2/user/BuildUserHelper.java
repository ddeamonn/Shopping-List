package lv.javaguru.java2.user;

import lv.javaguru.java2.data.registration.RegistrationInputData;
import lv.javaguru.java2.domain.User;
import org.springframework.stereotype.Component;

/**
 * Created by DMC on 11/28/2016.
 */

@Component
public class BuildUserHelper {

    UserBuilder builder;

    public BuildUserHelper createUser()    {

        this.builder = UserBuilder.createUser();
        return this;
    }

    public BuildUserHelper withRegistrationInputData(RegistrationInputData inputData) {
        this.builder.withMail(inputData.getEmail());
        this.builder.withPassword(inputData.getPassword());
        return this;
    }

    public User build () {
        return builder.build();
    }
}
