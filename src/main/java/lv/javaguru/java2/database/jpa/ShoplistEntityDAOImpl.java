package lv.javaguru.java2.database.jpa;

import lv.javaguru.java2.database.OrderItemDAO;
import lv.javaguru.java2.database.ShoplistEntityDAO;
import lv.javaguru.java2.domain.OrderItem;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.ShoplistEntity;
import lv.javaguru.java2.domain.User;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.criterion.Conjunction;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by DMC on 12/28/2016.
 */

@Component
@Qualifier("JPAShoplist")
public class ShoplistEntityDAOImpl extends GenericHibernateDAOImpl<ShoplistEntity> implements ShoplistEntityDAO {

    @Override
    @Transactional(readOnly=true)
    public ShoplistEntity getWithOrderItemsById(Long id) {
        ShoplistEntity shoplistEntity = getById(id);

        Hibernate.initialize(shoplistEntity.getOrderItems());

        return shoplistEntity;
    }

    @Override
    @Transactional(readOnly=true)
    public Collection<ShoplistEntity> getByUser(User user) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(persistentClass);
        criteria.add(Restrictions.eq("user", user));
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        return (Collection<ShoplistEntity>) criteria.list();
    }

    @Override
    @Transactional(readOnly=true)
    public ShoplistEntity getByNameAndUser(String name, User user) {
        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(persistentClass);
        criteria.add(Restrictions.eq("shoplistName", name));
        criteria.add(Restrictions.eq("user", user));
        return (ShoplistEntity)criteria.uniqueResult();
    }

    @Override
    @Transactional(readOnly = true)
    public Collection<ShoplistEntity> getByUserAndPeriod(User user, Date startDate, Date endDate) {

        Conjunction and = Restrictions.conjunction();

        and.add(Restrictions.eq("user", user));
        and.add(Restrictions.ge("addedTime", startDate));
        and.add(Restrictions.lt("addedTime", endDate));

        Criteria criteria = sessionFactory.getCurrentSession().createCriteria(persistentClass);
        criteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);
        criteria.add(and);
        return (Collection<ShoplistEntity>) criteria.list();

    }

}
