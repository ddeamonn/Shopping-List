package lv.javaguru.java2.authorisation;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by DMC on 12/27/2016.
 */
@Component
@Qualifier("LoginAuthorisation")
public class LoginAuthorisationService implements AuthorisationService {

    @Override
    public boolean authorise(AuthorisationContext context) {
        return true;
    }
}
