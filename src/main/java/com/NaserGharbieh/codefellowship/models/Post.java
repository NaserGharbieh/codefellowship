package com.NaserGharbieh.codefellowship.models;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  private   String body;
  private   LocalDate createdAt;

  @ManyToOne
  private ApplicationUser postByApplicationUser;



    public Post() {
    }



    public Post(String body,ApplicationUser postByApplicationUser) {
        this.body = body;

        this.postByApplicationUser=postByApplicationUser;
    }


    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }
    public Long getId() {
        return id;
    }
}
