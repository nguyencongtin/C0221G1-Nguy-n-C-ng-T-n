package com.case_study.model.service.impl;


import com.case_study.model.entity.question.Question;
import com.case_study.model.entity.question.QuestionType;
import com.case_study.model.repository.question.IQuestionRepository;
import com.case_study.model.repository.question.IQuestionTypeRepository;
import com.case_study.model.service.IQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class QuestionService implements IQuestionService {

    @Autowired
    IQuestionRepository iQuestionRepository;

    @Autowired
    IQuestionTypeRepository iQuestionTypeRepository;

    @Override
    public List<QuestionType> findAllQuestionType() {
        return (List<QuestionType>) iQuestionTypeRepository.findAll();
    }

    @Override
    public List<Question> findAll() {
        return (List<Question>) iQuestionRepository.findAll();
    }

    @Override
    public Page<Question> findAll(String title, String name, Pageable pageable) {
        return iQuestionRepository.findAllQuestion(title,name,pageable);
    }

    @Override
    public Page<Question> findAll(String name, Pageable pageable) {
        return null;
    }

    @Override
    public Question findById(Long id) {
        return iQuestionRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Question o) {
        iQuestionRepository.save(o);

    }

    @Override
    public void remove(Long id) {
        iQuestionRepository.deleteById(id);

    }
}
