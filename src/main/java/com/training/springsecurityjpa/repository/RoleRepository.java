package com.training.springsecurityjpa.repository;

import com.training.springsecurityjpa.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role , Long> {
}
