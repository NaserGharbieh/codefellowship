package com.NaserGharbieh.codefellowship.config;

import com.NaserGharbieh.codefellowship.models.ApplicationUser;
import com.NaserGharbieh.codefellowship.repositries.ApplicationUserRipository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    ApplicationUserRipository applicationUserRipository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        ApplicationUser applicationUser=applicationUserRipository.findByUsername(username);

        if(applicationUser== null){
            System.out.println("User not found "+ username);
            throw new UsernameNotFoundException("user"+ username+ " was not found in the db");
        }
        System.out.println("User  found "+applicationUser.getUsername());
        return applicationUser;
        }

    }

