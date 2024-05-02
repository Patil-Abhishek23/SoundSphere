package com.kodnest.soundsphere.serviceimplimentation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kodnest.soundsphere.entity.User;
import com.kodnest.soundsphere.repository.UserRepository;
import com.kodnest.soundsphere.service.UserService;

@Service
public class UserServiceImplimentation implements UserService {

	@Autowired
	UserRepository UserRepository;

	@SuppressWarnings("null")
	public String addUser(User user) {
		UserRepository.save(user);
		return "User added sucessfully";
	}

	
	
	
	
	public boolean emailExists(String email) {
		if (UserRepository.findByEmail(email) != null) {
			return true;
		}

		else {
			return false;

		}
	}

	
	
	
	
	
	
	
	
	
	
	public boolean ValidateUser(String email, String password) {

		User user = UserRepository.findByEmail(email);
		String dbpass = user.getPassword();

		if (password.equals(dbpass)) {
			
			return true;
		} 
		else {
			
			return false;
		}

	}

	
	
	
	
	
	
	
	
	
	public String getRole(String email) {

		User user = UserRepository.findByEmail(email);

		return user.getRole();
	}

	public User getUser(String email) {
		return UserRepository.findByEmail(email);
	}

	@SuppressWarnings("null")
	public void updateUser(User user) {
		UserRepository.save(user);

	}

}
