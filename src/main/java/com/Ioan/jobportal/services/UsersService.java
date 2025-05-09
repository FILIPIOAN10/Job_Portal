package com.Ioan.jobportal.services;


import com.Ioan.jobportal.entity.JobSeekerProfile;
import com.Ioan.jobportal.entity.RecruiterProfile;
import com.Ioan.jobportal.entity.Users;
import com.Ioan.jobportal.repository.JobSeekerProfileRepository;
import com.Ioan.jobportal.repository.RecruiterProfileRepository;
import com.Ioan.jobportal.repository.UsersRepository;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;


@Service
public class UsersService {

    private final UsersRepository usersRepository;

    private final JobSeekerProfileRepository jobSeekerProfileRepository;
    private final RecruiterProfileRepository recruiterProfileRepository;

    private final PasswordEncoder passwordEncoder;

    public UsersService(UsersRepository usersRepository,JobSeekerProfileRepository jobSeekerProfileRepository,RecruiterProfileRepository recruiterProfileRepository,
                        PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.jobSeekerProfileRepository = jobSeekerProfileRepository;
        this.recruiterProfileRepository=recruiterProfileRepository;
        this.passwordEncoder=passwordEncoder;
    }



    public Users addNew(Users users) {

        users.setActive(true);
        users.setRegistrationDate(new Date(System.currentTimeMillis()));


        users.setPassword(passwordEncoder.encode(users.getPassword()));


        Users savedUser = usersRepository.save(users);


        int userTypeId = users.getUserTypeId().getUserTypeId();


        if (userTypeId == 1) {

            recruiterProfileRepository.save(new RecruiterProfile(savedUser));
        } else {

            jobSeekerProfileRepository.save(new JobSeekerProfile(savedUser));
        }


        return users;
    }


    public Optional<Users> getUserByEmail(String email) {
        return usersRepository.findByEmail(email);
    }


    public Object getCurrentUserProfile() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();


        if (!(authentication instanceof AnonymousAuthenticationToken)) {

            String userName = authentication.getName();


            Users users = usersRepository.findByEmail(userName)
                    .orElseThrow(() -> new UsernameNotFoundException("Could not find user"));

            int userId = users.getUserId();


            if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("Recruiter"))) {
                return recruiterProfileRepository.findById(userId).orElse(null);
            } else {

                return jobSeekerProfileRepository.findById(userId).orElse(null);
            }
        }
        return null;
    }


    public Users getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (!(authentication instanceof AnonymousAuthenticationToken)) {
            String userName = authentication.getName();

            Users user = usersRepository.findByEmail(userName)
                    .orElseThrow(() -> new UsernameNotFoundException("Could not found user"));

            return user;
        }
        return null;
    }

    public Users findByEmail(String currentUsername) {
        return usersRepository.findByEmail(currentUsername)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

}
