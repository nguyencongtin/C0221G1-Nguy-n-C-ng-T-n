package com.model.service;

import com.model.entity.Comment;

import java.util.List;

public interface ICommentService {
   List<Comment> commentList();
   void addComment(Comment comment);
   void addLikes(int id);
}
