package com.controller;

import com.model.entity.Comment;
import com.model.service.ICommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = {"imgOfDay",""})
public class CommentController {
    @Autowired
    private ICommentService iCommentService;

    @GetMapping("")
    public ModelAndView showHome() {
        return new ModelAndView("home", "comment",new Comment())
                .addObject("listComment",iCommentService.commentList());
    }
    @PostMapping("/comment")
    public String comment(@ModelAttribute Comment comment){
        iCommentService.addComment(comment);
        return "redirect:/imgOfDay/";
    }
    @GetMapping("/like")
    public String like(@RequestParam int id){
        iCommentService.addLikes(id);
        return "redirect:/imgOfDay/";
    }


}