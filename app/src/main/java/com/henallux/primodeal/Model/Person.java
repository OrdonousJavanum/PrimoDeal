package com.henallux.primodeal.Model;

import android.annotation.TargetApi;
import android.os.Build;

import com.henallux.primodeal.Exception.InscriptionException;

/**
 * Created by bil on 19-11-17.
 */

public class Person {

    private String first_name, last_name, email, password, shop_name, shop_description, city, street;
    private Integer zip;


    public Person(String first_name, String last_name, String email, String password, String shop_name, String shop_description, String city, String street, Integer zip) throws InscriptionException {
        setFirst_name(first_name);
        setLast_name(last_name);
        setEmail(email);
        setPassword(password);
        setShop_name(shop_name);
        setShop_description(shop_description);
        setCity(city);
        setStreet(street);
        setZip(zip);
    }

    public Person(String first_name, String last_name, String email, String password) throws InscriptionException {
        setFirst_name(first_name);
        setLast_name(last_name);
        setEmail(email);
        setPassword(password);
    }


    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name)throws InscriptionException
    {
        if(first_name.equals("")|| !estAlphabetique(first_name))
            throw new InscriptionException(1);
        else
            this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) throws InscriptionException {
            if(last_name.equals("")|| !estAlphabetique(last_name))
                throw new InscriptionException(2);
            else
                this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) throws InscriptionException {
        if(email.equals("")|| !isValidEmail(email))
            throw new InscriptionException(3);
        else
            this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) throws InscriptionException {
        if(password.equals(""))
            throw new InscriptionException(4);
        else
            this.password = password;
    }

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name)throws InscriptionException {
            if(shop_name.equals(""))
                throw new InscriptionException(5);
            else
                this.shop_name = shop_name;
    }

    public String getShop_description() {
        return shop_description;
    }

    public void setShop_description(String shop_description)throws InscriptionException {
        if(shop_description.equals(""))
            throw new InscriptionException(6);
        else
            this.shop_description = shop_description;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) throws InscriptionException
    {
        if(city.equals("")|| !estAlphabetique(city))
            throw new InscriptionException(7);
        else
            this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) throws InscriptionException
    {
        if(street.equals("")|| !estAlphabetique(street))
            throw new InscriptionException(8);
        else
            this.street = street;
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
                valeur = false;
                if(s[i]=='-'||s[i]==' ' || s[i]=='\'')
                    valeur=true;
            }
        }
        return valeur;
    }

    public static boolean estNumeric(Integer num)
    {
        return true;
    }

    public final static boolean isValidEmail(CharSequence target) {
        if (target == null) {
            return false;
        } else {
            return android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
        }
    }
}
