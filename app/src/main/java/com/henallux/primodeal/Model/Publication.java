package com.henallux.primodeal.Model;

/**
 * Created by bil on 26-02-18.
 */

public class Publication {

    private String id, title, description, applicationUserId;
    private PersonReturnModel applicationUser;
    private Integer yes, no, dontknow;

    public Publication(String title, String description){

    }

    public Publication(String title, String description, PersonReturnModel applicationUser){
        System.out.println("lalalalla");
    }

    public Publication(String title, String description, Integer yes, Integer no, Integer dontknow,PersonReturnModel applicationUser ){
        this.title = title;
        this.description = description;
        this.yes = yes;
        this.no = no;
        this.dontknow = dontknow;
        this.applicationUser = applicationUser;
    }

    public Publication(String title, String description, Integer yes, Integer no, Integer dontknow, String applicationUserId){
        this.title = title;
        this.description = description;
        this.yes = yes;
        this.no = no;
        this.dontknow = dontknow;
        this.applicationUserId = applicationUserId;
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

    public PersonReturnModel getApplicationUser() {
        return applicationUser;
    }

    public void setApplicationUser(PersonReturnModel applicationUser) {
        this.applicationUser = applicationUser;
    }
}
