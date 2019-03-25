package com.cnpc.repository;

import com.cnpc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    User findById(String id);
}