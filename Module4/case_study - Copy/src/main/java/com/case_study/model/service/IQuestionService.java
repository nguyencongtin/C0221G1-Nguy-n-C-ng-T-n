package com.case_study.model.service;

import com.case_study.model.entity.question.Question;
import com.case_study.model.entity.question.QuestionType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IQuestionService extends IGeneralService<Question>{
    List<QuestionType> findAllQuestionType();
    List<Question> findAll();
    Page<Question> findAll(String title, String name, Pageable pageable);
}
