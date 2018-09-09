package com.demo.dbservice.dbservice.repository;

import com.demo.dbservice.dbservice.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByuserid(String usrId);
}
