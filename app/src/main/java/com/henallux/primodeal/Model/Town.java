package com.henallux.primodeal.Model;

import com.henallux.primodeal.Exception.InscriptionException;

/**
 * Created by bil on 27-11-17.
 */

public class Town {

    private String city_name;
    private Integer zip;
    private Country country;

    public Town(String city_name, Integer zip, Country country) {
        this.city_name = city_name;
        this.zip = zip;
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public String getCity_name() {
        return city_name;
    }


    public void setCity_name(String city_name) throws InscriptionException
    {
        if(city_name.equals("")|| !estAlphabetique(city_name))
            throw new InscriptionException(7);
        else
            this.city_name = city_name;
    }

    public Integer getZip() {
        return zip;
    }

    public void setZip(Integer zip) throws InscriptionException
    {
        if(zip.equals("")|| !estNumeric(zip))
            throw new InscriptionException(9);
        else
            this.zip = zip;
    }

    public static boolean estAlphabetique(String chaine)
    {
        char[] s = chaine.toCharArray();
        boolean valeur = true;

        for(int i=0; i<s.length;i++)
        {
            if(!Character.isLetter(s[i])&& valeur)
            {
                valeur = s[i] == '-' || s[i] == ' ' || s[i] == '\'';
            }
        }
        return valeur;
    }

    public static boolean estNumeric(Integer num)
    {
        return true;
    }

}
