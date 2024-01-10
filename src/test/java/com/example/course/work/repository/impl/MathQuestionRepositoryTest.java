package com.example.course.work.repository.impl;

import com.example.course.work.model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Collection;

import static com.example.course.work.constants.Constants.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MathQuestionRepositoryTest {
    private MathQuestionRepository questionRepository;

    @BeforeEach
    public void setUp() {
        questionRepository = new MathQuestionRepository();
    }

    @Test
    public void addQuestion() {
//        Given

//        When
        Question actual = questionRepository.add(QUESTION_OBJ_1);

//        Then
        assertEquals(QUESTION_OBJ_1, actual);
    }

    @Test
    public void removeQuestion() {
//        Given
        questionRepository.add(QUESTION_OBJ_1);

//        When
        Question actual = questionRepository.remove(QUESTION_OBJ_1);

//        Then
        assertEquals(QUESTION_OBJ_1, actual);
    }

    @Test
    public void getAll() {
//        Given
        questionRepository.add(QUESTION_OBJ_1);
        questionRepository.add(QUESTION_OBJ_2);
        questionRepository.add(QUESTION_OBJ_3);
        questionRepository.add(QUESTION_OBJ_4);

//        When
        Collection<Question> actual = questionRepository.getAll();

//        Then
        assertEquals(QUESTION_COLLECTION, actual);
    }
}
