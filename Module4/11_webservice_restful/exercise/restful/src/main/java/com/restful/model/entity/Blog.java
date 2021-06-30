package com.restful.model.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Blog {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String content;
    private String auther;
    private Date date=new Date(System.currentTimeMillis());

    @ManyToOne
    @JoinColumn
    private Category category;
    public Blog() {
    }

    public Blog(Long id, String content, String auther, Date date) {
        this.id = id;
        this.content = content;
        this.auther = auther;
        this.date = date;
    }

    public Blog(Long id, String content, String auther, Date date, Category category) {
        this.id = id;
        this.content = content;
        this.auther = auther;
        this.date = date;
        this.category = category;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
