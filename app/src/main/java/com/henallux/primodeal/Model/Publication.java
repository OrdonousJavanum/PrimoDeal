package com.henallux.primodeal.Model;

/**
 * Created by bil on 26-02-18.
 */

public class Publication {

    private String id, title, description;
    private Person person;
    private int yes, no, dontknow;

    public Publication(String title, String description){

    }

    public Publication(String title, String description, Person person, int yes, int no, int dontknow ){
        this.title = title;
        this.description = description;
        this.person = person;
        this.yes = yes;
        this.no = no;
        this.dontknow = dontknow;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
