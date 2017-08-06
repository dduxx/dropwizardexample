package com.dduxx.dropwizardexample;

import com.dduxx.dropwizardexample.dao.TestUserDAO;
import com.dduxx.dropwizardexample.domain.TestUser;
import com.dduxx.dropwizardexample.resources.TestUserResource;

import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.hibernate.HibernateBundle;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class Application extends io.dropwizard.Application<Configuration>{

    private final HibernateBundle<Configuration> hibernate = new HibernateBundle<Configuration>(TestUser.class) {
        @Override
        public DataSourceFactory getDataSourceFactory(Configuration configuration) {
            return configuration.getDataSourceFactory();
        }
    };
    
    @Override
    public void initialize(Bootstrap<Configuration> bootstrap) {
        bootstrap.addBundle(hibernate);
    }
    
    @Override
    public void run(Configuration config, Environment env) throws Exception {
        TestUserDAO dao = new TestUserDAO(hibernate.getSessionFactory());
        env.jersey().register(new TestUserResource(dao));     
        env.jersey().setUrlPattern("/api/*");  
    }
    
    public static void main(String[] args) throws Exception{
        new Application().run(args);
    }

}
