package com.kaufland.vmdb.dto;

import com.kaufland.vmdb.domain.Account;
import com.kaufland.vmdb.domain.Comment;

public class CommentDTO {

    private Account author;

    private String content;

    private byte rating;

    public CommentDTO(Comment comment){
        this.author = comment.getAuthor();
        this.content = comment.getContent();
        this.rating = comment.getRating();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public byte getRating() {
        return rating;
    }

    public void setRating(byte rating) {
        this.rating = rating;
    }

    public Account getAuthor() {
        return author;
    }

    public void setAuthor(Account author) {
        this.author = author;
    }
}
