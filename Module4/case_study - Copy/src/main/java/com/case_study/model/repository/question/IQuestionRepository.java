package com.case_study.model.repository.question;

import com.case_study.model.entity.question.Question;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IQuestionRepository extends PagingAndSortingRepository<Question,Long> {
@Query(value = "select * from question where title like %?1% and question_name like %?2% and flag=0 order by id desc ",nativeQuery = true)
Page<Question> findAllQuestion(String title, String name, Pageable pageable);

}
