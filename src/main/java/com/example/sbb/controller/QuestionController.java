package com.example.sbb.controller;

import com.example.sbb.entity.Question;
import com.example.sbb.repository.QuestionRepository;
import com.example.sbb.service.QuestionService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class QuestionController {
    private QuestionService questionService;

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

}
