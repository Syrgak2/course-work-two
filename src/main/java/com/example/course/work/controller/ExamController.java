package com.example.course.work.controller;

import com.example.course.work.model.Question;
import com.example.course.work.service.ExaminerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("exam")
public class ExamController {
    private ExaminerService examinerService;

    public ExamController(ExaminerService examinerService) {
        this.examinerService = examinerService;
    }

    @GetMapping("/get/{amount}")
    public List<Question> getRandomQuestions(@PathVariable("amount") Integer amount) {
        return examinerService.getQuestions(amount);
    }
}
