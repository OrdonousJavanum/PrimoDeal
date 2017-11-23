package com.henallux.primodeal.Model;

import com.henallux.primodeal.Exception.PublicationException;

/**
 * Created by bil on 23-11-17.
 */

public class Question {

    private String question_name;
    private Answer answer;
    private Answer[] tabAnswer = new Answer[100];

    public Question(String question_name, Answer answer)throws PublicationException {
        setQuestion_name(question_name);
        this.answer = answer;
    }

    public String getQuestion_name() {
        return question_name;
    }

    public void setQuestion_name(String question_name) throws PublicationException {
            if(question_name.equals(""))
                throw new PublicationException(3);
            else
                this.question_name = question_name;
    }

    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }

    public Answer[] getTabAnswer() {
        return tabAnswer;
    }

    public void setTabAnswer(Answer[] tabAnswer) {
        this.tabAnswer = tabAnswer;
    }
}
