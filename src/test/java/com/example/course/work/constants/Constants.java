package com.example.course.work.constants;

import com.example.course.work.model.Question;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class Constants {
    public static final String QUESTION_1 = "question1";
    public static final String QUESTION_2 = "question2";
    public static final String QUESTION_3 = "question3";
    public static final String QUESTION_4 = "question4";

    public static final String ANSWER_1 = "answer1";
    public static final String ANSWER_2 = "answer2";
    public static final String ANSWER_3 = "answer3";
    public static final String ANSWER_4 = "answer4";

    public static final Question QUESTION_OBJ_1 = new Question(QUESTION_1, ANSWER_1);
    public static final Question QUESTION_OBJ_2 = new Question(QUESTION_2, ANSWER_2);
    public static final Question QUESTION_OBJ_3 = new Question(QUESTION_3, ANSWER_3);
    public static final Question QUESTION_OBJ_4 = new Question(QUESTION_4, ANSWER_4);

    public static final Collection<Question> QUESTION_COLLECTION = Set.of(
            QUESTION_OBJ_1,
            QUESTION_OBJ_2,
            QUESTION_OBJ_3,
            QUESTION_OBJ_4
    );

    public static final List<Question> JAVA_QUESTION_LIST = new ArrayList<>(
            List.of(
                    QUESTION_OBJ_1,
                    QUESTION_OBJ_2
            )
    );

    public static final List<Question> MATH_QUESTION_LIST = new ArrayList<>(
            List.of(
                    QUESTION_OBJ_3,
                    QUESTION_OBJ_4
            )
    );





}
