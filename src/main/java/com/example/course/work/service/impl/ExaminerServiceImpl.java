package com.example.course.work.service.impl;

import com.example.course.work.exception.IllegalAmountException;
import com.example.course.work.model.Question;
import com.example.course.work.service.ExaminerService;
import com.example.course.work.service.QuestionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    private QuestionService questionService;

    public ExaminerServiceImpl(QuestionService questionService) {
        this.questionService = questionService;
    }

    @Override
    public List<Question> getQuestions(int amount) {

        if (questionService.getAll().size() > amount) {
            throw new IllegalAmountException();
        }

        return getRandomQuestions(amount);

    }

    private List<Question> getRandomQuestions(int amount) {
        List<Question> questionsForReturn = new ArrayList<>();

        int index = 0;

        while (index != amount) {
            Question rand = questionService.getRandomQuestion();
            if (questionsForReturn.isEmpty()) {
                questionsForReturn.add(rand);
                index += 1;
            } else {
                if (!questionsForReturn.contains(rand)) {
                    questionsForReturn.add(rand);
                    index += 1;
                }
            }
        }

        return questionsForReturn;
    }
}
