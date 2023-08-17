package com.example.contactsystem.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.contactsystem.entity.User;



@EnableJpaRepositories
@Repository
public interface UserRepo extends JpaRepository<User , Long>{

	User getUserByUserName(String username);
	
	User getUserByUserId(long id);
	
	Optional<User> findOneByEmailAndPassword(String userEmail, String userPassword);
	User findByEmail(String email);
	
}
