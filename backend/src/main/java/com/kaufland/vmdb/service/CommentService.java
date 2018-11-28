package com.kaufland.vmdb.service;

import com.kaufland.vmdb.domain.Account;
import com.kaufland.vmdb.domain.Comment;
import com.kaufland.vmdb.domain.Movie;
import com.kaufland.vmdb.dto.CommentDTO;

import java.util.List;

public interface CommentService {

    List<Comment> all();

    List<Comment> getByUser         (Account user);

    List<CommentDTO> getByMovie     (Movie movie, int page);

    CommentService publishComment   (Movie movie, Comment comment);

    CommentService modifyComment    (Comment comment);

}
