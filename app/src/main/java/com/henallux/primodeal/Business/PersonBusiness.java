package com.henallux.primodeal.Business;

import com.henallux.primodeal.DataAccess.PersonDao;
import com.henallux.primodeal.Model.Person;
import com.henallux.primodeal.Model.PersonInterface;

/**
 * Created by bil on 19-11-17.
 */

public class PersonBusiness {

    private PersonInterface personInterface;

    public PersonBusiness(){
        personInterface = new PersonDao();
    }

    public void addPerson(Person person) throws Exception {
        personInterface.addPerson(person);
    }
}
