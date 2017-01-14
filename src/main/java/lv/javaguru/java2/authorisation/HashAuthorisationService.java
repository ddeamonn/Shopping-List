package lv.javaguru.java2.authorisation;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by DMC on 12/27/2016.
 */

@Component
@Qualifier("HashAuthorisation")
public class HashAuthorisationService implements AuthorisationService {

    @Override
    public boolean authorise(AuthorisationContext context) {
        return true;
    }
}
