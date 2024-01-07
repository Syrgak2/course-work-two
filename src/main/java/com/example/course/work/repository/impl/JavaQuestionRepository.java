package com.example.course.work.repository.impl;

import com.example.course.work.exception.QuestionNotFoundException;
import com.example.course.work.model.Question;
import com.example.course.work.repository.QuestionRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Repository
@Qualifier("javaQuestionRepository")
public class JavaQuestionRepository implements QuestionRepository {
    Set<Question> questions = new HashSet<>();

    @PostConstruct
    public void init() {
        questions.add(new Question("Что такое массив",
                "Массив это тип данных, в котором хранится упорядоченный набор однотипных элементов"));
        questions.add(new Question("Расскажи про ООП",
                "методология или стиль программирования на основе описания типов/моделей предметной области и их взаимодействия"));
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }



    @Override
    public Question remove(Question question) {
        if (!questions.contains(question)) {
            throw new QuestionNotFoundException();
        }
        questions.remove(question);
        return question;
    }

    @Override
    public Collection<Question> getAll() {
        return questions;
    }
}
