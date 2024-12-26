package com.sankeerth.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sankeerth.model.Login;
@Repository
public interface LoginRepo extends JpaRepository<Login, Integer> {
	Optional<Login> findByusername(String username);
}
