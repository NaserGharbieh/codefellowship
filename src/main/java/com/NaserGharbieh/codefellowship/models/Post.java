package com.NaserGharbieh.codefellowship.models;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  private   String body;
  private   LocalDate createdAt;

  @ManyToOne
  private ApplicationUser applicationUser;



    public Post() {
    }



    public Post(String body,ApplicationUser applicationUser) {
        this.body = body;

        this.applicationUser = applicationUser;
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
    public ApplicationUser getApplicationUser() {
        return applicationUser;
    }


    public void setApplicationUser(ApplicationUser postByApplicationUser) {
        this.applicationUser = postByApplicationUser;
    }

}
