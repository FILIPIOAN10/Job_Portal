package com.Ioan.jobportal.repository;

import com.Ioan.jobportal.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;



//Give you common CRUD functionality out of the box
public interface UsersRepository extends JpaRepository<Users,Integer> {
    Optional<Users> findByEmail(String email);


}
