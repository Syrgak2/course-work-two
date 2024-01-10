package com.example.course.work.service.impl;

import com.example.course.work.exception.IllegalAmountException;
import com.example.course.work.model.Question;
import com.example.course.work.service.ExaminerService;
import com.example.course.work.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class ExaminerServiceImpl implements ExaminerService {
    @Autowired
    @Qualifier("javaQuestionService")
    private QuestionService javaQuestionService;

    @Autowired
    @Qualifier("mathQuestionService")
    private QuestionService mathQuestionService;

    private Random random = new Random();


    @Override
    public List<Question> getQuestions(int amount) {
        int numberOfQuestions = javaQuestionService.getAll().size() + mathQuestionService.getAll().size();
        if (numberOfQuestions < amount) {
            throw new IllegalAmountException();
        }

        int javaQuestionSize = random.nextInt(amount);

        return getRandomQuestions(amount, javaQuestionSize);

    }

    private List<Question> getRandomQuestions(int amount, int size) {
        List<Question> tmp = new ArrayList<>();
        int index = 0;

        while (index != amount) {
            if (index < size) {
                Question randJavaQuestion = javaQuestionService.getRandomQuestion();
                if (tmp.isEmpty()) {
                    tmp.add(randJavaQuestion);
                    index += 1;
                } else if (!tmp.contains(randJavaQuestion)) {
                    tmp.add(randJavaQuestion);
                    index += 1;
                }
            } else {
                Question randMathQuestion = mathQuestionService.getRandomQuestion();
                if (tmp.isEmpty()) {
                    tmp.add(randMathQuestion);
                    index += 1;
                } else if (!tmp.contains(randMathQuestion)) {
                    tmp.add(randMathQuestion);
                    index += 1;
                }
            }
        }
        return tmp;
    }
}
