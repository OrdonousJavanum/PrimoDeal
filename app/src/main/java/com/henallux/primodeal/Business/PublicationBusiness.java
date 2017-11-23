package com.henallux.primodeal.Business;

import com.henallux.primodeal.DataAccess.PublicationDao;
import com.henallux.primodeal.Model.Publication;
import com.henallux.primodeal.Model.PublicationInterface;

/**
 * Created by bil on 23-11-17.
 */

public class PublicationBusiness {

    private PublicationInterface publicationInterface;

    public PublicationBusiness(){
        publicationInterface = new PublicationDao();
    }

    public void addPublication(Publication publication) {
       publicationInterface.addPublication(publication);
    }

}
