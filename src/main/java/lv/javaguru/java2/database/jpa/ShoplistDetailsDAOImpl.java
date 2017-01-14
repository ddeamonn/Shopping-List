package lv.javaguru.java2.database.jpa;

import lv.javaguru.java2.database.ProductDAO;
import lv.javaguru.java2.database.ShoplistDetailsDAO;
import lv.javaguru.java2.domain.Product;
import lv.javaguru.java2.domain.ShoplistDetails;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by DMC on 12/28/2016.
 */

@Component
@Qualifier("JPAShoplist")
public class ShoplistDetailsDAOImpl extends GenericHibernateDAOImpl<ShoplistDetails> implements ShoplistDetailsDAO {

}
