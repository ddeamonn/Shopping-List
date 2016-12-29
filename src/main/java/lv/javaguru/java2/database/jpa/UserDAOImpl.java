package lv.javaguru.java2.database.jpa;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Created by DMC on 12/28/2016.
 */

@Component
@Qualifier("JPAUser")
public class UserDAOImpl extends GenericHibernateDAOImpl<User> implements UserDAO {

}
