package com.henallux.primodeal.Model;

import com.henallux.primodeal.Exception.PublicationException;

/**
 * Created by bil on 23-11-17.
 */

public class Publication {

    private String title, description;
    private Question question;

    private Question[] tabQuestion = new Question[100];

    public Publication(String title, String description, Question question) throws PublicationException {
        setTitle(title);
        setDescription(description);
        this.question = question;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title)throws PublicationException {
        if(title.equals(""))
            throw new PublicationException(1);
        else
            this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description)throws PublicationException {
        if(description.equals(""))
            throw new PublicationException(2);
        else
            this.description = description;
    }
}
