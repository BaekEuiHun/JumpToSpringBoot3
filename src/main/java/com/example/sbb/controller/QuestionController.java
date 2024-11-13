package com.example.sbb.controller;

import com.example.sbb.entity.Question;

import com.example.sbb.service.QuestionService;


import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class QuestionController {

    private final QuestionService questionService;

    @GetMapping("/")
    public String root() {
        return "redirect:/question/list";
    }

    //질문 목록 데이터 조회
    @GetMapping("/question/list")
    public String list(Model model) {
        List<Question> questionList = this.questionService.getList();
        model.addAttribute("questionList", questionList);
        return "question_list";
    }

    //상세 페이지
    @GetMapping(value = "/question/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id) {
        Question question = this.questionService.getQuestion(id);
        model.addAttribute("question", question);
        return "question_detail";
    }

    //질문 등록하기 페이지 불러오기
    @GetMapping("/question/create")
    public String questionCreate() {
        return "question_form";
    }

    //질문 등록하기
    @PostMapping("/question/create")
    public String questionCreate(@RequestParam(value = "subject") String subject, @RequestParam(value = "content") String content) {
        this.questionService.create(subject, content);
        return "redirect:/question/list";
    }

}
