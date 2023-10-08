package com.NaserGharbieh.codefellowship.repositries;

import com.NaserGharbieh.codefellowship.models.ApplicationUser;
import com.NaserGharbieh.codefellowship.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface PostsRepository extends JpaRepository<Post,Long> {

    List<Post> findAllByApplicationUserIn(Set<ApplicationUser> followed);
}
