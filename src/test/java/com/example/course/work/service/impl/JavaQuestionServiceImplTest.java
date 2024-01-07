package com.example.course.work.service.impl;


import com.example.course.work.exception.QuestionAlreadyAddedException;
import com.example.course.work.exception.QuestionNotFoundException;
import com.example.course.work.model.Question;
import com.example.course.work.repository.impl.JavaQuestionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

import static com.example.course.work.constants.Constants.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class JavaQuestionServiceImplTest {

    @Mock
    private JavaQuestionRepository javaQuestionRepository;

    @InjectMocks
    private JavaQuestionServiceImpl javaQuestionService;



    @Test
    public void addQuestion() {
//        Given
        when(javaQuestionRepository.add(QUESTION_OBJ_1)).thenReturn(QUESTION_OBJ_1);

//        When
        Question actual = javaQuestionService.addQuestion(QUESTION_OBJ_1);

//        Then

        Assertions.assertEquals(QUESTION_OBJ_1, actual);
    }

    @Test
    public void removeQuestion() {
//        Given
        when(javaQuestionRepository.remove(QUESTION_OBJ_1)).thenReturn(QUESTION_OBJ_1);

//        When
        Question actual = javaQuestionService.removeQuestion(QUESTION_OBJ_1);

//        Then
        Assertions.assertEquals(QUESTION_OBJ_1, actual);
    }

    @Test
    public void getAll() {
//        Given
        when(javaQuestionRepository.getAll()).thenReturn(QUESTION_COLLECTION);
        List<Question> excepted = new ArrayList<>(QUESTION_COLLECTION);

//        When
        List<Question> actual = javaQuestionService.getAll();

//        Then
        Assertions.assertEquals(excepted, actual);
    }

}
