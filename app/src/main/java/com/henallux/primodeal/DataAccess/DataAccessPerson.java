package com.henallux.primodeal.DataAccess;

import com.henallux.primodeal.Model.Person;
import com.henallux.primodeal.Model.PersonInterface;

/**
 * Created by bil on 19-11-17.
 */

public class DataAccessPerson implements PersonInterface {


    @Override
    public void addPerson(Person person) {
        System.out.println("add personne dataAccss");

        // voir cour pour insertion dans la web api
    }
}
