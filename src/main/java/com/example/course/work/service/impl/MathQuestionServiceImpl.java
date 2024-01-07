package com.example.course.work.service.impl;

import com.example.course.work.model.Question;
import com.example.course.work.repository.QuestionRepository;
import com.example.course.work.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Qualifier("mathQuestionService")
public class MathQuestionServiceImpl implements QuestionService {
    @Autowired
    @Qualifier("mathQuestionRepository")
    private QuestionRepository questionRepo;

    @Override
    public Question addQuestion(String question, String answer) {
        Question requestedQuestion = new Question(question, answer);

        return addQuestion(requestedQuestion);
    }

    @Override
    public Question addQuestion(Question question) {
        return questionRepo.add(question);
    }

    @Override
    public Question removeQuestion(Question question) {
        return questionRepo.remove(question);
    }

    @Override
    public List<Question> getAll() {
        return new ArrayList<>(questionRepo.getAll());
    }

    @Override
    public Question getRandomQuestion() {
        Random random = new Random();
        int index = random.nextInt(getAll().size());
        return getAll().get(index);

    }

}
