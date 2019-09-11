package com.smsr.rest.buildingblocks.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.smsr.rest.buildingblocks.entities.User;
import com.smsr.rest.buildingblocks.exceptions.UserExistsException;
import com.smsr.rest.buildingblocks.exceptions.UserNotFoundException;
import com.smsr.rest.buildingblocks.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}
	
	public User createUser(User user) throws UserExistsException{
		User existingUser = userRepository.findByUsername(user.getUsername());
		
		if(existingUser != null ) {
			throw new UserExistsException("User already exists in the repository");
		} else {
			return userRepository.save(user);
		}
	}
	
	public Optional<User> getUserById(Long id) throws UserNotFoundException {
		
		Optional<User> user = userRepository.findById(id);
		
		if(!user.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		}
		return user;
	}
	
	public User updateUserById(Long id, User user) throws UserNotFoundException {
		
		Optional<User> findUser = userRepository.findById(id);
		
		if (!findUser.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		} else {
		
			user.setId(id);
			return userRepository.save(user);
		}
		
	}
	
	public void deleteUserById(Long id) {
		
		Optional<User> user = userRepository.findById(id);
		
		
		if(!user.isPresent()) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found");
		} else  {
			userRepository.deleteById(id);
		}
	}
	
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}
}
