package com.dduxx.dropwizardexample.dao;

import java.util.List;

import org.hibernate.SessionFactory;

import com.dduxx.dropwizardexample.domain.TestUser;

import io.dropwizard.hibernate.AbstractDAO;

public class TestUserDAO extends AbstractDAO<TestUser> {

    public TestUserDAO(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
    
    public TestUser selectById(Integer id){
        return get(id);
    }
    
    public List<TestUser> select(){
        return list(criteria());
    }

}
