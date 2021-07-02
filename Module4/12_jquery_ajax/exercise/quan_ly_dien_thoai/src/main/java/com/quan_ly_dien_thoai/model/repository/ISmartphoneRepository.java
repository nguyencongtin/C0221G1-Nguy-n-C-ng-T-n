package com.quan_ly_dien_thoai.model.repository;

import com.quan_ly_dien_thoai.model.entity.Smartphone;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ISmartphoneRepository extends CrudRepository<Smartphone, Long> {
}
