package com.dduxx.dropwizardexample;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.dropwizard.db.DataSourceFactory;

public class Configuration extends io.dropwizard.Configuration {
    @Valid
    @NotNull
    @JsonProperty("database")
    private DataSourceFactory database = new DataSourceFactory();
    
    public DataSourceFactory getDataSourceFactory(){
        return database;
    }
    
    public void setDataSourceFactory(DataSourceFactory database){
        this.database = database;
    }
}
