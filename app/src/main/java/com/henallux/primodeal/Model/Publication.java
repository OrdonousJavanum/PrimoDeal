package com.henallux.primodeal.Model;

/**
 * Created by bil on 26-02-18.
 */

public class Publication {
    private int  id;
    private String title, description;
    private Person person;

    public Publication(String title, String description){}


    public int getId() {
        return id;
    }

    public void setId(int id) {
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
