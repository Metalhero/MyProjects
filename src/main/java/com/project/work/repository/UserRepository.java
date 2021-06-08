package com.project.work.repository;

import com.project.work.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    List<User> findAll();

    User findByUsername(String username);

    List<User> findAllByEmail(String email);

    User findByActivationCode(String code);
}
