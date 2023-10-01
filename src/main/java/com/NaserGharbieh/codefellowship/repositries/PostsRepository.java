package com.NaserGharbieh.codefellowship.repositries;

import com.NaserGharbieh.codefellowship.models.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostsRepository extends JpaRepository<Post,Long> {
}
