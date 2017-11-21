package com.henallux.primodeal.Controller;

import com.henallux.primodeal.Business.PersonBusiness;
import com.henallux.primodeal.Model.Person;

/**
 * Created by bil on 19-11-17.
 */

public class Controller {

    private PersonBusiness personBusiness;

    public Controller()
    {
        personBusiness = new PersonBusiness();
    }

    public void addPerson(Person person) throws Exception {
        personBusiness.addPerson(person);
    }

}
