package com.example.course.work.service.impl;

import com.example.course.work.model.Question;
import com.example.course.work.repository.impl.JavaQuestionRepository;
import com.example.course.work.repository.impl.MathQuestionRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static com.example.course.work.constants.Constants.QUESTION_COLLECTION;
import static com.example.course.work.constants.Constants.QUESTION_OBJ_1;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MathQuestionServiceImplTest {
    @Mock
    private MathQuestionRepository mathQuestionRepository;

    @InjectMocks
    private MathQuestionServiceImpl mathQuestionService;



    @Test
    public void addQuestion() {
//        Given
        when(mathQuestionRepository.add(QUESTION_OBJ_1)).thenReturn(QUESTION_OBJ_1);

//        When
        Question actual = mathQuestionService.addQuestion(QUESTION_OBJ_1);

//        Then

        Assertions.assertEquals(QUESTION_OBJ_1, actual);
    }

    @Test
    public void removeQuestion() {
//        Given
        when(mathQuestionRepository.remove(QUESTION_OBJ_1)).thenReturn(QUESTION_OBJ_1);

//        When
        Question actual = mathQuestionService.removeQuestion(QUESTION_OBJ_1);

//        Then
        Assertions.assertEquals(QUESTION_OBJ_1, actual);
    }

    @Test
    public void getAll() {
//        Given
        when(mathQuestionRepository.getAll()).thenReturn(QUESTION_COLLECTION);
        List<Question> excepted = new ArrayList<>(QUESTION_COLLECTION);

//        When
        List<Question> actual = mathQuestionService.getAll();

//        Then
        Assertions.assertEquals(excepted, actual);
    }
}
