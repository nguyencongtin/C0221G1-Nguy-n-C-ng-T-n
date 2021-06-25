package com.example.nang_cap_ung_dung_blog.model.repository;

import com.example.nang_cap_ung_dung_blog.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {
//    Cách 1: dùng câu lệnh query
    @Query(value="select * from blog where auther like %?1%",nativeQuery=true)
    Page<Blog> searchByName(Pageable pageable, String nameSearch);
//    Cách 2: dùng interface
//    Page<Blog> findAllByAutherContaining(Pageable pageable,String nameSearch);
    @Query(value="select * from blog order by `date` desc",nativeQuery=true)
    Page<Blog> findAllByOrderByDate(Pageable pageable);

//    @Query (value="insert into blog (auther,content)\n" +
//            "values (?1,?2);",nativeQuery=true)
//    void createBlog(String auther, String content);
}
