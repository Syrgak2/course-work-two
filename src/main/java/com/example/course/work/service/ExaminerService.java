package com.example.course.work.service;

import com.example.course.work.model.Question;

import java.util.List;

public interface ExaminerService {
    List<Question> getQuestions(int amount);
}
