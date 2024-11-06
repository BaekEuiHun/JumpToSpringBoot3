package com.example.sbb.repository;

import com.example.sbb.entity.Answer;
import com.example.sbb.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AnswerRepository extends JpaRepository<Answer, Integer> {

}
