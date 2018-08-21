package com.kaufland.vmdb.service;

import com.kaufland.vmdb.domain.Account;
import com.kaufland.vmdb.domain.Comment;
import com.kaufland.vmdb.domain.Movie;

import java.util.List;

public interface CommentService {

    List<Comment> all();

    List<Comment> getByUser         (Account user);

    List<Comment> getByMovie        (Movie movie);

    CommentService publishComment   (Movie movie, Comment comment);

    CommentService modifyComment    (Comment comment);

}
