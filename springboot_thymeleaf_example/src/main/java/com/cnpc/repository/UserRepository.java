package com.cnpc.repository;

import com.cnpc.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("select u from User u")
    Page<User> pageList(Pageable pageable);

    User findById(int id);

    User findByUserName(String username);

    void deleteById(int id);
}
