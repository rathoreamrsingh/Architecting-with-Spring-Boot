package com.demo.userservice.repository;

import com.demo.userservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByuserid(String usrId);

    User findByUseridAndPassword(String username, String Password);
}
