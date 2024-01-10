package com.example.course.work.service;

import com.example.course.work.model.Question;

import java.util.List;

public interface QuestionService {
    Question addQuestion(String question, String answer);

    Question addQuestion(Question question);

    Question removeQuestion(Question question);

    List<Question> getAll();

    Question getRandomQuestion();
}
