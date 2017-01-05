package lv.javaguru.java2.registration;

import lv.javaguru.java2.data.registration.RegistrationInputData;
import lv.javaguru.java2.domain.User;

/**
 * Created by DMC on 1/4/2017.
 */
public interface RegistrationService {
    boolean register(User user);
}
