package service.impl;

import domain.Account;
import domain.Comment;
import domain.Movie;
import service.CommentService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CommentServiceImpl implements CommentService {

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
