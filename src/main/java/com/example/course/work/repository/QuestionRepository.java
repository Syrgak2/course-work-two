package com.example.course.work.repository;

import com.example.course.work.model.Question;

import java.util.Collection;
import java.util.stream.Collectors;

public interface QuestionRepository {
    Question add(Question question);

    Question remove(Question question);

    Collection<Question> getAll();
}
