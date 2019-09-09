package com.smsr.rest.buildingblocks.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.smsr.rest.buildingblocks.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
}
