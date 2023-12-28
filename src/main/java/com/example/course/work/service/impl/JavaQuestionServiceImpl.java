package com.example.course.work.service.impl;

import com.example.course.work.exception.QuestionAlreadyAddedException;
import com.example.course.work.exception.QuestionNotFoundException;
import com.example.course.work.model.Question;
import com.example.course.work.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class JavaQuestionServiceImpl implements QuestionService {
    private List<Question> questions = new ArrayList<>();

    @Override
    public Question addQuestion(String question, String answer) {
        Question requestedQuestion = new Question(question, answer);

        return addQuestion(requestedQuestion);
    }

    @Override
    public Question addQuestion(Question question) {

        if (questions.contains(question)) {
            throw new QuestionAlreadyAddedException();
        }

        questions.add(question);
        return question;
    }

    @Override
    public Question removeQuestion(Question question) {

        if (!questions.contains(question)) {
            throw new QuestionNotFoundException();
        }

        questions.remove(question);
        return question;
    }

    @Override
    public List<Question> getAll() {
        return questions;
    }

    @Override
    public Question getRandomQuestion() {
        return questions.get(generateRandomNumber());

    }

    private int generateRandomNumber() {
        int minValue = 0;
        int maxValue = questions.size() - 1;
        return minValue + (int) (Math.random() * (maxValue - minValue + 1));
    }


}
