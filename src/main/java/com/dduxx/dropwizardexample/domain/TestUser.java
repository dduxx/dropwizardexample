package com.dduxx.dropwizardexample.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="test_users")
public class TestUser {
    
    @Id
    @Column(name="id")
    private Integer id;
    
    @Column(name="name")
    private String name;

    public TestUser() {
        
    }
    
    public TestUser(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TestUser [id=" + id + ", name=" + name + "]";
    }
}
