package lv.javaguru.java2.user;

import lv.javaguru.java2.data.registration.RegistrationInputData;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.utils.DateUtils;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;

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

    public BuildUserHelper withCurrentAddedTime() {
        Timestamp currentTime = DateUtils.getCurrentTimestamp();
        this.builder.withAddedTime(currentTime);
        return this;
    }

    public User build () {
        return builder.build();
    }
}
