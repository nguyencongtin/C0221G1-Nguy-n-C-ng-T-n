package com.restful.model.repository;

import com.restful.model.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Long> {
//    Cách 1: dùng câu lệnh query
    @Query(value="select * from blog where auther like %?1%",nativeQuery=true)
    Page<Blog> searchByName(Pageable pageable, String nameSearch);
//    Cách 2: dùng interface
//    Page<Blog> findAllByAutherContaining(Pageable pageable,String nameSearch);
    @Query(value="select * from blog order by `date` desc",nativeQuery=true)
    Page<Blog> findAllByOrderByDate(Pageable pageable);

    @Query(value="select * from blog where category_id = ?1",nativeQuery=true)
    List<Blog> findBlogWithSameCategory(Long id);

//    @Query (value="insert into blog (auther,content)\n" +
//            "values (?1,?2);",nativeQuery=true)
//    void createBlog(String auther, String content);
}
