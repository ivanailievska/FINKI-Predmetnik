package com.finki.ukim.mk.predmetnik.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ocpsoft.prettytime.PrettyTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer ID;

    private LocalDateTime timestamp;

    private String body;

    private Integer likes;

    private Integer dislikes;

    private String authorName;

    public String getTimestampFormatted() {
        PrettyTime p = new PrettyTime();
        return p.format(this.timestamp);
    }

    @PrePersist
    public void onSave() {
        if (likes == null) {
            likes = 0;
        }
        if (dislikes == null) {
            dislikes = 0;
        }
    }
}