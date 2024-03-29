package com.ung_dung_blog.model.service;

import com.ung_dung_blog.model.entity.Blog;
import com.ung_dung_blog.model.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService extends IGeneralService<Blog> {

    Page<Blog> findAllByOrderByDateDesc(Pageable pageable);

    List<Blog> findAllByCategory(Category category);

    Page<Blog> findAll(Pageable pageable);

    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);
    List<Blog> findAllByTitleContaining(String title);

}
