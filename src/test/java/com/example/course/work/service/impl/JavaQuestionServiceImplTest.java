package com.example.course.work.service.impl;


import com.example.course.work.exception.QuestionAlreadyAddedException;
import com.example.course.work.exception.QuestionNotFoundException;
import com.example.course.work.model.Question;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class JavaQuestionServiceImplTest {

    private final String questionTestValue = "Question";
    private final String answerTestValue = "Answer";

    private Question question;

    private JavaQuestionServiceImpl javaQuestionService;

    @BeforeEach
    public void setUp() {
        javaQuestionService = new JavaQuestionServiceImpl();
        question = new Question(questionTestValue, answerTestValue);
    }

    @Test
    public void addQuestion() {
//        Given
        Question expected = new Question(questionTestValue, answerTestValue);

//        When
        Question actual = javaQuestionService.addQuestion(questionTestValue, answerTestValue);

//        Then

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void removeQuestion() {
//        Given
        Question expected = new Question(questionTestValue, answerTestValue);
        javaQuestionService.addQuestion(question);

//        When
        Question actual = javaQuestionService.removeQuestion(question);

//        Then
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void getAll() {
        Question question1 = new Question("test question", "test answer");
//        Given
        List<Question> expected = new ArrayList<>();
        expected.add(question);
        expected.add(question1);

//        When
        javaQuestionService.addQuestion(question);
        javaQuestionService.addQuestion(question1);

        List<Question> actual = javaQuestionService.getAll();

        Assertions.assertEquals(expected, actual);
    }

    //    All QuestionAlreadyAddedException
    @Test
    public void whenQuestionAdded() {
//        Given
        javaQuestionService.addQuestion(question);

//        Then
        Assertions.assertThrows(
                QuestionAlreadyAddedException.class,
                () -> javaQuestionService.addQuestion(question)
        );
    }

//    All QuestionNotFoundException
    @Test
    public void whenQuestionNotFound() {
//        Given
        javaQuestionService.addQuestion(question);
        Question wrongQuestion = new Question("Wrong", "Question");

//        Then
        Assertions.assertThrows(
                QuestionNotFoundException.class,
                () -> javaQuestionService.removeQuestion(wrongQuestion)
        );

    }
}
