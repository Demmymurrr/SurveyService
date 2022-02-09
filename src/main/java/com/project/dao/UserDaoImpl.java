package com.project.dao;

import com.project.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    private final SessionFactory sessionFactory;

    public UserDaoImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    private Session getSession() {
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public User getIdByUsername(String username) {
        User user = (User) getSession().createQuery("from User where username='"+username+"'").uniqueResult();
        return user;
    }

    @Override
    public User getById(Long id) {
        return getSession().get(User.class,id);
    }
}
