package com.example.ung_dung_blog.model.repository;

import com.example.ung_dung_blog.model.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {
//    @Query (value="insert into blog (auther,content)\n" +
//            "values (?1,?2);",nativeQuery=true)
//    void createBlog(String auther, String content);
}
