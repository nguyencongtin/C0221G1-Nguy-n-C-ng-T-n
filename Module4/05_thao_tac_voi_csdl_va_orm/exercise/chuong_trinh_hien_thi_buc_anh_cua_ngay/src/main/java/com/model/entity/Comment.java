package com.model.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import java.util.Date;
@Entity
public class Comment {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private int id;
    private int rate;
    private String author;
    private String feedback;
    private Date time = new Date(System.currentTimeMillis());
    private int likes;

    public Comment() {
    }

    public Comment(int rate, String author, String feedback, Date time, int likes) {
        this.rate = rate;
        this.author = author;
        this.feedback = feedback;
        this.time = time;
        this.likes = likes;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }


}
