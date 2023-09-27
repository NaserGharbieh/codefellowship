package com.NaserGharbieh.codefellowship.repositries;

import com.NaserGharbieh.codefellowship.models.ApplicationUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ApplicationUserRipository extends JpaRepository<ApplicationUser,Long> {
    ApplicationUser findByUsername(String username);
}
