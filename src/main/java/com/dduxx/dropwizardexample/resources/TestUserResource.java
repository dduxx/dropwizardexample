package com.dduxx.dropwizardexample.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.dduxx.dropwizardexample.dao.TestUserDAO;

import io.dropwizard.hibernate.UnitOfWork;

@Path("/test")
@Produces(MediaType.APPLICATION_JSON)
public class TestUserResource {

    private TestUserDAO dao;
    
    public TestUserResource(TestUserDAO dao){
        this.dao = dao;
    }
    
    @GET
    @UnitOfWork
    @Path("/{id}")
    public Response getTestUser(@PathParam("id") Integer id){
        return Response.ok().entity(dao.selectById(id)).build();
    }
    
    @GET
    @UnitOfWork
    public Response getTestUser(){
        return Response.ok().entity(dao.select()).build();
    }
}
