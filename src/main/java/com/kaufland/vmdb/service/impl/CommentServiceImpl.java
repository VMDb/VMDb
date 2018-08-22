package com.kaufland.vmdb.service.impl;

import com.kaufland.vmdb.domain.Account;
import com.kaufland.vmdb.domain.Comment;
import com.kaufland.vmdb.domain.Movie;
import com.kaufland.vmdb.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    /**
     *TODO Replace with CommentRepository
     *TODO Redo methods
     */
    private List<Comment> comments;

    public CommentServiceImpl(){
        this.comments = new ArrayList<>();
    }

    @Override
    public List<Comment> all() {
        return new ArrayList<>(comments);
    }

    @Override
    public List<Comment> getByUser(Account user) {
        return comments.stream()
                       .filter(comment -> comment.getAuthor().equals(user))
                       .collect(Collectors.toList());
    }

    @Override
    public List<Comment> getByMovie(Movie movie) {
        return comments.stream()
                       .filter(comment -> comment.getMovie().equals(movie))
                       .collect(Collectors.toList());
    }

    @Override
    public CommentService publishComment(Movie movie, Comment comment) {



        return this;
    }

    @Override
    public CommentService modifyComment(Comment comment) {

        return this;
    }
}
