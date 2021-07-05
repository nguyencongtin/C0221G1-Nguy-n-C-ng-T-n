package com.example.demo.model.repository;

import com.example.demo.model.entity.AppUser;
import com.example.demo.model.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
    List<UserRole>  findByAppUser(AppUser appUser);
}
