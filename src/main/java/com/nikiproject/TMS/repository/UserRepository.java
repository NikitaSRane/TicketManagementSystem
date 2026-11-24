package com.nikiproject.TMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nikiproject.TMS.model.User;

public interface UserRepository extends JpaRepository<User, Long>{

	boolean existsByEmail(String email);
}
