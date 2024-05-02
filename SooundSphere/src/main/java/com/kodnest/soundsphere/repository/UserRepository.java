package com.kodnest.soundsphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodnest.soundsphere.entity.User;

public interface UserRepository extends JpaRepository<User, String> {

	public User findByEmail(String email);

}
