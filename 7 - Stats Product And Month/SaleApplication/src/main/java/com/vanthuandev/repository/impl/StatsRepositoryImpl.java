package com.vanthuandev.repository.impl;

import com.vanthuandev.pojos.Category;
import com.vanthuandev.pojos.OrderDetail;
import com.vanthuandev.pojos.Product;
import com.vanthuandev.pojos.SaleOrder;
import com.vanthuandev.repository.StatsRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
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
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rootP = q.from(Product.class);
        Root rootO = q.from(SaleOrder.class);
        Root rootD = q.from(OrderDetail.class);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rootD.get("productId"), rootP.get("id")));
        predicates.add(b.equal(rootD.get("orderId"), rootO.get("id")));

        q.multiselect(rootP.get("id"), rootP.get("name"),
                b.sum(b.prod(rootD.get("unitPrice"), rootD.get("num"))));

        if (kw != null && !kw.isEmpty())
            predicates.add(b.like(rootP.get("name"), String.format("%%%s%%", kw)));

        if (fromDate != null)
            predicates.add(b.greaterThanOrEqualTo(rootO.get("createdDate"), fromDate));

        if (toDate != null)
            predicates.add(b.lessThanOrEqualTo(rootO.get("createdDate"), toDate));

        q.where(predicates.toArray(new Predicate[]{}));

        q.groupBy(rootP.get("id"));

        Query query = session.createQuery(q);

        return query.getResultList();
    }

    @Override
    public List<Object[]> productMonthStats(String kw, Date fromDate, Date toDate) {
        Session session = this.sessionFactory.getObject().getCurrentSession();

        CriteriaBuilder b = session.getCriteriaBuilder();
        CriteriaQuery<Object[]> q = b.createQuery(Object[].class);

        Root rootP = q.from(Product.class);
        Root rootO = q.from(SaleOrder.class);
        Root rootD = q.from(OrderDetail.class);

        List<Predicate> predicates = new ArrayList<>();
        predicates.add(b.equal(rootD.get("productId"), rootP.get("id")));
        predicates.add(b.equal(rootD.get("orderId"), rootO.get("id")));

        q.multiselect(b.function("MONTH", Integer.class, rootO.get("createdDate")),
                b.function("YEAR", Integer.class, rootO.get("createdDate")),
                b.sum(b.prod(rootD.get("unitPrice"), rootD.get("num"))));

        if (kw != null && !kw.isEmpty())
            predicates.add(b.like(rootP.get("name"), String.format("%%%s%%", kw)));

        if (fromDate != null)
            predicates.add(b.greaterThanOrEqualTo(rootO.get("createdDate"), fromDate));

        if (toDate != null)
            predicates.add(b.lessThanOrEqualTo(rootO.get("createdDate"), toDate));

        q.where(predicates.toArray(new Predicate[]{}));

        q.groupBy(b.function("MONTH", Integer.class, rootO.get("createdDate")),
                b.function("YEAR", Integer.class, rootO.get("createdDate")));

        Query query = session.createQuery(q);

        return query.getResultList();
    }
}
