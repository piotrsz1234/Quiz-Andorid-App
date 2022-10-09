package com.piotsz.zad1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public final class MainActivity extends AppCompatActivity {

    private TextView _spQuestionText;
    private Button _btnTrueAnswer;
    private Button _btnFalseAnswer;
    private Button _btnNextQuestion;

    private int _currentQuestionIndex;
    private Question[] _questions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        _currentQuestionIndex = 0;
        _questions = QuestionMocks.GetQuestions();
        this.assignControls();
        this.initControls();
        this.displayQuestion(_questions[_currentQuestionIndex]);
    }

    private void assignControls() {
        _spQuestionText = findViewById(R.id.spQuestionText);
        _btnTrueAnswer = findViewById(R.id.btnTrueAnswer);
        _btnFalseAnswer = findViewById(R.id.btnFalseAnswer);
        _btnNextQuestion = findViewById(R.id.btnNextQuestion);
    }

    private void initControls() {
        _btnTrueAnswer.setOnClickListener(view -> checkAnswer(_questions[_currentQuestionIndex], true));

        _btnFalseAnswer.setOnClickListener(view -> checkAnswer(_questions[_currentQuestionIndex], false));

        _btnNextQuestion.setOnClickListener(view -> {
            _currentQuestionIndex = (_currentQuestionIndex + 1) % _questions.length;
            displayQuestion(_questions[_currentQuestionIndex]);
        });
    }

    private void displayQuestion(Question question) {
        _spQuestionText.setText(question.QuestionTextId);
    }

    private void checkAnswer(Question question, boolean answer) {
        if(question.IsTrue == answer) {
            Toast.makeText(this, R.string.CorrectAnswer, Toast.LENGTH_SHORT).show();
            return;
        }
        Toast.makeText(this, R.string.IncorrectAnswer, Toast.LENGTH_SHORT).show();
    }
}