package lv.javaguru.java2.authorisation;

/**
 * Created by DMC on 12/27/2016.
 */
public interface AuthorisationService {
    boolean authorise(AuthorisationContext context);
}
