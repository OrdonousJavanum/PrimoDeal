package com.henallux.primodeal.Business;

import com.henallux.primodeal.DataAccess.PersonDao;
import com.henallux.primodeal.Model.LoginForm;
import com.henallux.primodeal.Model.Person;
import com.henallux.primodeal.Model.PersonInterface;

/**
 * Created by bil on 19-11-17.
 */

    public class PersonBusiness{
    private PersonInterface personInterface;
    private int test;

    public PersonBusiness(){
       // personInterface = new PersonDao();
    }

    public void login(LoginForm loginForm) throws Exception {
        personInterface.login(loginForm);
    }
}
