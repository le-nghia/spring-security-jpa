package com.training.springsecurityjpa.repository;

import com.training.springsecurityjpa.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User , Long> {
}
