/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.restfulmaven_jpa;

import entity.City;
import util.JSONtranslator;
import util.EntityHandler;
import javax.persistence.Persistence;
import javax.ws.rs.Consumes;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author xboxm
 */
@Path("country")
public class CountryResource{
    
    private final EntityHandler eh;
    private final JSONtranslator jsonT = new JSONtranslator();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CountryResource
     */
    public CountryResource() {
        eh = new EntityHandler(Persistence.createEntityManagerFactory("persistenceunit"));
    }

    /**
     * Retrieves representation of an instance of rest.CountryResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String getXml() {
        return "Hello country";
    }

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllCountries() {
        return jsonT.ListToJson(eh.getAllCountries());
    }
    
    @GET
    @Path("population/{minPopulation}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getAllCountriesWithPopulationGreaterThan(@PathParam("minPopulation") int minPopulation) {
        return jsonT.ListToJson(eh.getAllCountriesWithPopulationGreaterThan(minPopulation));
    }
    
    @GET
    @Path("city/{countryCode}")
    public String getAllCities(@PathParam("countryCode") String countryCode) {
        return jsonT.ListToJson(eh.getAllCities(countryCode));
    }
    
    
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public String addCity(String jsonCity) {
        City city = eh.addCity(jsonT.JsonToCity(jsonCity));
        return jsonT.CityToJson(city); 
    }
    
}