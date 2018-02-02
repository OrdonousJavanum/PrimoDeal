package com.henallux.primodeal.Controller;

import com.henallux.primodeal.Business.PersonBusiness;
import com.henallux.primodeal.Business.PublicationBusiness;
import com.henallux.primodeal.Model.LoginForm;
import com.henallux.primodeal.Model.Person;
import com.henallux.primodeal.Model.Publication;

/**
 * Created by bil on 19-11-17.
 */

public class Controller {

    private PersonBusiness personBusiness;
    private PublicationBusiness publicationBusiness;


    public Controller()
    {
        personBusiness = new PersonBusiness();
        publicationBusiness = new PublicationBusiness();
    }

    /*public void addPerson(Person person) throws Exception {
        personBusiness.addPerson(person);
    }*/

    public  void addPublication(Publication publication){
        publicationBusiness.addPublication(publication);
    }

    public void login(LoginForm loginForm) throws Exception {
        personBusiness.login(loginForm);
    }



}
