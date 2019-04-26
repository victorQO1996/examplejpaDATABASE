package com.uabc.database.example.examplejpa.repository;

import com.uabc.database.example.examplejpa.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Serializable> {
    public abstract User findByUsername(String username);
}
