package com.piotsz.zad1;

public final class QuestionMocks {

    public static Question[] GetQuestions() {
        return new Question[] {
                new Question(R.string.Question1, true),
                new Question(R.string.Question2, true),
                new Question(R.string.Question3, false)
        };
    }
}
