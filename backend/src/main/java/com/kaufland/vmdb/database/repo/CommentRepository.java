package com.kaufland.vmdb.database.repo;

import com.kaufland.vmdb.domain.Comment;
import com.kaufland.vmdb.domain.Movie;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    List<Comment> findAll();

    List<Comment> findAllByMovieTitle(String title);

    List<Comment> findAllByAuthorId(Long id);

    List<Comment> findAllByMovie(Movie movie, Pageable page);
}
