package com.case_study.model.repository.question;

import com.case_study.model.entity.question.QuestionType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IQuestionTypeRepository extends PagingAndSortingRepository<QuestionType,Long> {
}
