package com.henallux.primodeal.Model;

/**
 * Created by Lightning Lord on 10-12-17.
 */

public class QuestionChoice {
    private Integer id;
    private String choiceTitle;
    private Integer countChoice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCountChoice() {
        return countChoice;
    }

    public void setCountChoice(Integer countChoice) {
        this.countChoice = countChoice;
    }

    public QuestionChoice(String choiceTitle) {

        this.choiceTitle = choiceTitle;
    }

    public String getChoiceTitle() {
        return choiceTitle;
    }

    public void setChoiceTitle(String choiceTitle) {
        this.choiceTitle = choiceTitle;
    }
}
