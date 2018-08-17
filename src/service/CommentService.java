package service;

import domain.Account;
import domain.Comment;
import domain.Movie;

import java.util.List;

public interface CommentService {

    List<Comment> all();

    List<Comment> getByUser         (Account user);

    List<Comment> getByMovie        (Movie movie);

    CommentService publishComment   (Movie movie, Comment comment);

    CommentService modifyComment    (Comment comment);

}
