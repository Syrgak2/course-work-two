package com.example.course.work.service.impl;

import com.example.course.work.exception.IllegalAmountException;
import com.example.course.work.model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    private ExaminerServiceImpl examinerService;

    private List<Question> questionListForTesting;

    private Question question;
    private Question question1;

    @Mock
    private JavaQuestionServiceImpl javaQuestionService;

    @BeforeEach
    public void setUp() {
        examinerService = new ExaminerServiceImpl(javaQuestionService);

        questionListForTesting = new ArrayList<>();
        questionListForTesting.add(question);
        questionListForTesting.add(question1);

        Mockito.when(javaQuestionService.getRandomQuestion()).thenReturn(question);

    }

    @Test
    public void getQuestions() {
//        Given
        List<Question> expected = new ArrayList<>();
        expected.add(question);

//        When
        List<Question> actual = examinerService.getQuestions(1);

//        Then
        Assertions.assertEquals(expected, actual);

    }

}
