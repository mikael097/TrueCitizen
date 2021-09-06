package com.rogue.truecitizen.model;

public class Question {
    int quesResId;
    boolean answer;

    public Question(int quesResId, boolean answer) {
        this.quesResId = quesResId;
        this.answer = answer;
    }

    public int getQuesResId() {
        return quesResId;
    }

    public void setQuesResId(int quesResId) {
        this.quesResId = quesResId;
    }

    public boolean isAnswer() {
        return answer;
    }

    public void setAnswer(boolean answer) {
        this.answer = answer;
    }
}
