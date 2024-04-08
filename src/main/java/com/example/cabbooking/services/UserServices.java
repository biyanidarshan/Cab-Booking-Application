package com.example.cabbooking.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cabbooking.exceptions.UserAlreadyPresent;
import com.example.cabbooking.models.User;
import com.example.cabbooking.repository.UserRepository;

@Service
public class UserServices {
	
	@Autowired
	private UserRepository userRepository;

	public UserServices(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	
	public boolean add_User (User user) throws UserAlreadyPresent {
		if (userRepository.checkUserDetails(user))
			throw new UserAlreadyPresent("User already registered in the databse");
		else
			return userRepository.add_User_Repository(user);
	}
}


