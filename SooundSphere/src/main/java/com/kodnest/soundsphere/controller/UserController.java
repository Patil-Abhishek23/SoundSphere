package com.kodnest.soundsphere.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kodnest.soundsphere.entity.Song;
import com.kodnest.soundsphere.entity.User;
import com.kodnest.soundsphere.service.SongService;
import com.kodnest.soundsphere.serviceimplimentation.UserServiceImplimentation;

import jakarta.servlet.http.HttpSession;

@Controller
public class UserController {

	@Autowired
	UserServiceImplimentation serviceImpl;

	@Autowired
	SongService songService;

	@PostMapping("/register")
	public String addUser(@ModelAttribute User user) {

		String email = user.getEmail();

		boolean status = serviceImpl.emailExists(email);

		if (status == false) {
			serviceImpl.addUser(user);
			System.out.println("User added");

		} else {

			System.out.println("User already exists");
			return "login";

		}

		return "login";
	}

	@PostMapping("/validate")
	public String validates(@RequestParam("email") String email, @RequestParam("password") String password,
			HttpSession session, Model model) {

		if (serviceImpl.ValidateUser(email, password) == true) {

			String role = serviceImpl.getRole(email);

			session.setAttribute("email", email);

			if (role.equals("admin")) {

				return "admin";
			} else {
				User user = serviceImpl.getUser(email);
				boolean userstatus = user.isPreminum();
				if (userstatus == false) {
					return "pay";
				}
				List<Song> songList = songService.fetchAllSongs();
				model.addAttribute("songs", songList);
				model.addAttribute("ispremium", userstatus);
				return "displaysongs";
			}
		} else {
			return "login";
		}

	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "login";
	}

}
