package com.henallux.primodeal.Model;

import com.henallux.primodeal.Exception.InscriptionException;

/**
 * Created by bil on 27-11-17.
 */

public class Country {

    private String name_country;

    public Country(String name_country) throws InscriptionException{
        setName_country(name_country);
    }

    public String getName_country() {
        return name_country;
    }

    public void setName_country(String country) throws InscriptionException
    {
        if(country.equals("")|| !estAlphabetique(country))
            throw new InscriptionException(7);
        else
            this.name_country = country;
    }

    public static boolean estAlphabetique(String chaine)
    {
        char[] s = chaine.toCharArray();
        boolean valeur = true;

        for(int i=0; i<s.length;i++)
        {
            if(!Character.isLetter(s[i])&& valeur)
            {
                valeur = false;
                if(s[i]=='-'||s[i]==' ' || s[i]=='\'')
                    valeur=true;
            }
        }
        return valeur;
    }

}
