package com.example.course.work.service.impl;

import com.example.course.work.model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static com.example.course.work.constants.Constants.*;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ExaminerServiceImplTest {

    @Mock
    private JavaQuestionServiceImpl javaQuestionService;

    @Mock
    private MathQuestionServiceImpl mathQuestionService;

    @Mock
    private Random random;

    @InjectMocks
    ExaminerServiceImpl examinerService;

    @Test
    public void getQuestions() {
        List<Question> test = new ArrayList<>();
        test.add(QUESTION_OBJ_1);
        test.add(QUESTION_OBJ_2);

        List<Question> test2 = new ArrayList<>();
        test2.add(QUESTION_OBJ_3);
        test2.add(QUESTION_OBJ_4);


//        Given
        when(javaQuestionService.getRandomQuestion()).thenReturn(QUESTION_OBJ_1);
        when(mathQuestionService.getRandomQuestion()).thenReturn(QUESTION_OBJ_3);
        when(javaQuestionService.getAll()).thenReturn(test);
        when(javaQuestionService.getAll()).thenReturn(test2);
        when(random.nextInt(anyInt())).thenReturn(1);

        List<Question> expected = new ArrayList<>();
        expected.add(QUESTION_OBJ_1);
        expected.add(QUESTION_OBJ_3);

//        When
        List<Question> actual = examinerService.getQuestions(2);

//        Then
        Assertions.assertEquals(expected, actual);

    }

}
