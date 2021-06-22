package com.example.tao_ung_dung_blog.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Blog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String auther;

    public Blog() {
    }

    public Blog(long id, String content, String auther) {
        this.id = id;
        this.content = content;
        this.auther = auther;
    }

    public Blog(String content, String auther) {
        this.content = content;
        this.auther = auther;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }
}
