package lv.javaguru.java2.database.jpa;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.domain.User;
import org.hibernate.Criteria;
import org.hibernate.JDBCException;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by DMC on 12/28/2016.
 */

@Component
@Qualifier("JPAUser")
public class UserDAOImpl extends GenericHibernateDAOImpl<User> implements UserDAO {

    @Override
    @Transactional(readOnly=true)
    public User getUserByEmail(String email) throws JDBCException {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(persistentClass);
        criteria.add(Restrictions.eq("email", email));
        return (User)criteria.uniqueResult();
    }
}
