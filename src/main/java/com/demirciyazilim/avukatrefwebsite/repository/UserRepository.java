package com.demirciyazilim.avukatrefwebsite.repository;

import com.demirciyazilim.avukatrefwebsite.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);
    boolean existsUserById(int id);
}
