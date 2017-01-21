package lv.javaguru.java2.authorization;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by DMC on 12/27/2016.
 */

@Component
@Qualifier("HashAuthorisation")
public class HashAuthorizationService implements AuthorizationService {

    @Override
    public boolean authorize(AuthorizationContext context) {
        return true;
    }
}
