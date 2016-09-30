/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import com.google.gson.Gson;
import entity.City;
import entity.Country;
import java.util.List;

/**
 *
 * @author Martin
 */
public class JSONtranslator {

    private Gson gson = new com.google.gson.GsonBuilder().setPrettyPrinting().create();
    
    public String ListToJson(List list) {
        return gson.toJson(list);
    }

    public City JsonToCity(String json) {
        return gson.fromJson(json, City.class);
    }

    public Country JsonToCountry(String json) {
        return gson.fromJson(json, Country.class);
    }

    public String CityToJson(City c) {
        return gson.toJson(c);
    }

}