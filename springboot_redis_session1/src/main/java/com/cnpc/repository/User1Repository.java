package com.cnpc.repository;

import com.cnpc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface User1Repository extends JpaRepository<User, Long> {
    User findByUserName(String userName);
}