package com.login.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.login.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("SELECT u FROM User u WHERE u.username = :username")
	Optional<User> findUserByUsername(@Param("username") String username);

	@Query("SELECT u FROM User u WHERE u.username = :username AND u.pw = :pw")
	Optional<User> findByUsernameAndPw(@Param("username") String username, @Param("pw") String pw);

	User findByUsername(String username);
}