package com.henallux.primodeal.Model;

import com.henallux.primodeal.Exception.InscriptionException;

/**
 * Created by bil on 27-11-17.
 */

public class Country {

    private String name_country;

    public Country(String name_country) {
        this.name_country = name_country;
    }

    public String getName_country() {
        return name_country;
    }

    public void setName_country(String name_country) {
        this.name_country = name_country;
    }

}
