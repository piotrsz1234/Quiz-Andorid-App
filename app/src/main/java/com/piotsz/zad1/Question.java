package com.piotsz.zad1;

public final class Question {
    public final int QuestionTextId;
    public final boolean IsTrue;

    public Question(int questionTextId, boolean isTrue) {
        IsTrue = isTrue;
        QuestionTextId = questionTextId;
    }
}
