package com.kaufland.vmdb.service.impl;

import com.kaufland.vmdb.database.repo.CommentRepository;
import com.kaufland.vmdb.domain.Account;
import com.kaufland.vmdb.domain.Comment;
import com.kaufland.vmdb.domain.Movie;
import com.kaufland.vmdb.dto.CommentDTO;
import com.kaufland.vmdb.service.CommentService;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> all() {
        return commentRepository.findAll();
    }

    @Override
    public List<Comment> getByUser(Account user) {
        return commentRepository.findAllByAuthorId(user.getId());
    }

    @Override
    public List<CommentDTO> getByMovie(Movie movie, int page) {
        Pageable pageable = PageRequest.of(page, 10);
        return commentRepository.findAllByMovie(movie, pageable)
                                .stream()
                                .map(CommentDTO::new)
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
