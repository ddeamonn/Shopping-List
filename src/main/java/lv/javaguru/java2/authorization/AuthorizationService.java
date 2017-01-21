package lv.javaguru.java2.authorization;

/**
 * Created by DMC on 12/27/2016.
 */
public interface AuthorizationService {
    boolean authorize(AuthorizationContext context);
}
