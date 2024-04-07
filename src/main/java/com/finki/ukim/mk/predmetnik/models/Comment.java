package com.finki.ukim.mk.predmetnik.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import org.ocpsoft.prettytime.PrettyTime;

import java.time.LocalDateTime;

@Data
@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    private LocalDateTime timestamp;

    private String body;

    private Integer likes;

    private Integer dislikes;

    private String authorName;

    public Comment() {
    }

    public Comment(LocalDateTime timestamp, String body) {
        this.timestamp = timestamp;
        this.body = body;
        this.likes = 0;
        this.dislikes = 0;
    }

    public Comment(Integer ID, LocalDateTime timestamp, String body, Integer likes, Integer dislikes, String authorName) {
        this.ID = ID;
        this.timestamp = timestamp;
        this.body = body;
        this.likes = likes;
        this.dislikes = dislikes;
        this.authorName = authorName;
    }

    public Integer getLikes() {
        return likes;
    }

    public void setLikes(Integer likes) {
        this.likes = likes;
    }

    public Integer getDislikes() {
        return dislikes;
    }

    public void setDislikes(Integer dislikes) {
        this.dislikes = dislikes;
    }

    public String getTimestampFormatted() {
        PrettyTime p = new PrettyTime();
        return p.format(this.timestamp);
    }
    }