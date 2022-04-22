package com.vanthuandev.repository.impl;

import com.vanthuandev.pojos.Category;
import com.vanthuandev.pojos.Product;
import com.vanthuandev.repository.StatsRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.Date;
import java.util.List;

@Repository
@Transactional
public class StatsRepositoryImpl implements StatsRepository {
    @Autowired
    private LocalSessionFactoryBean sessionFactory;

    @Override
    public List<Object[]> cateStats() {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rootP = q.from(Product.class);
        Root rootC = q.from(Category.class);

        q.where(b.equal(rootP.get("categoryId"), rootC.get("id")));

        q.multiselect(rootC.get("id"), rootC.get("name"),
                b.count(rootP.get("id")));

        q.groupBy(rootC.get("id"));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> productStats(String kw, Date fromDate, Date toDate) {
        return null;
    }

    @Override
    public List<Object[]> productMonthStats(String kw, Date fromDate, Date toDate) {
        return null;
    }
}
