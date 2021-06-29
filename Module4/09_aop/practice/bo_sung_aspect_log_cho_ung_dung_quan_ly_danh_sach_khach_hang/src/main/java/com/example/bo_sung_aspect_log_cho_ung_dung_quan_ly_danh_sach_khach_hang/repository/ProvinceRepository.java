package com.example.bo_sung_aspect_log_cho_ung_dung_quan_ly_danh_sach_khach_hang.repository;

import com.example.bo_sung_aspect_log_cho_ung_dung_quan_ly_danh_sach_khach_hang.model.Province;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvinceRepository extends CrudRepository<Province, Long> {
}
