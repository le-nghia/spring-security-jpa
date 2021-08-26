package com.example.app.dao;

import com.example.app.entity.Account;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

@Transactional
@Repository
public class AccountDAO {

    @Autowired
    private EntityManager entityManager;

    public Account findAccount(String userName){
        /*Session session = this.sessionFactory.getCurrentSession();
        return session.find(Account.class, userName);*/
        try {
            String sql = "select e from " + Account.class.getName() + " e "
                    + " where e.name= :name";
            Query query = entityManager.createQuery(sql,Account.class);
            query.setParameter("name", userName);

            return (Account) query.getSingleResult();
        }catch (NoResultException e){
            return null;
        }
    }
}
