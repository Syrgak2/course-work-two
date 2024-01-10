package com.example.course.work.controller;

import com.example.course.work.model.Question;
import com.example.course.work.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/exam/math")
public class MathQuestionController {
    @Autowired
    @Qualifier("mathQuestionService")
    private QuestionService questionService;


    @GetMapping("add")
    public Question addQuestion(@RequestParam("question") String question,
                                @RequestParam("answer") String answer) {
        return questionService.addQuestion(new Question(question,answer));
    }

    @GetMapping("remove")
    public Question removeQuestion(@RequestParam("question") String question,
                                   @RequestParam("answer") String answer) {
        return questionService.removeQuestion(new Question(question, answer));
    }

    @GetMapping("")
    public List<Question> getQuestions() {
        return questionService.getAll();
    }
}
