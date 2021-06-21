package com.model.service.impl;

import com.model.entity.Comment;
import com.model.service.ICommentService;
import com.model.service.repository.BaseRepository;
import org.springframework.stereotype.Service;

import javax.persistence.EntityTransaction;
import java.util.List;
@Service
public class CommentServiceImpl implements ICommentService {
    @Override
    public List<Comment> commentList() {
        return BaseRepository.entityManager.createQuery("select c from Comment c",Comment.class).getResultList();

    }

    @Override
    public void addComment(Comment comment) {
        EntityTransaction entityTransaction= BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(comment);
        entityTransaction.commit();

    }

    @Override
    public void addLikes(int id) {
        Comment comment=BaseRepository.entityManager.find(Comment.class,id);
        comment.setLikes(comment.getLikes()+1);
        EntityTransaction entityTransaction=BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(comment);
        entityTransaction.commit();
    }
}
