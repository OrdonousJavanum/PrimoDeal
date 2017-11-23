package com.henallux.primodeal.DataAccess;

import com.henallux.primodeal.Model.Person;
import com.henallux.primodeal.Model.PersonInterface;
import com.henallux.primodeal.Model.Publication;
import com.henallux.primodeal.Model.PublicationInterface;

/**
 * Created by bil on 23-11-17.
 */

public class PublicationDao implements PublicationInterface {


    @Override
    public void addPublication(Publication publication)  {
        System.out.println(" publication post data access");
    }
}
