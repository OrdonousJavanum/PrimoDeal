package com.henallux.primodeal.Model;

import com.henallux.primodeal.Exception.PublicationException;

/**
 * Created by bil on 23-11-17.
 */

public class Answer {

    private  String answer;

    public Answer(String answer) throws PublicationException {
        setAnswer(answer);
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) throws PublicationException {
            if(answer.equals(""))
                throw new PublicationException(4);
            else
                this.answer = answer;
    }

}
