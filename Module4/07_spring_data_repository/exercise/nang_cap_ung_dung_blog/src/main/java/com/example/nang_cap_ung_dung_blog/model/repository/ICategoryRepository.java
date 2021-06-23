package com.example.nang_cap_ung_dung_blog.model.repository;

import com.example.nang_cap_ung_dung_blog.model.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
