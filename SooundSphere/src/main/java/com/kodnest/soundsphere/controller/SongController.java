package com.kodnest.soundsphere.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.kodnest.soundsphere.entity.Song;
import com.kodnest.soundsphere.service.SongService;
import com.kodnest.soundsphere.serviceimplimentation.UserServiceImplimentation;

import jakarta.servlet.http.HttpSession;

@Controller
public class SongController {

	@Autowired
	SongService SongService;

	@Autowired
   UserServiceImplimentation serviceImpl;
	

	@PostMapping("/addsong")
	public String addsong(@ModelAttribute Song song,HttpSession session) {

		if (song.getLink() == null) {
			session.invalidate();
			return "newsong";
		} else {
			SongService.addSong(song);

		}
		session.invalidate();
		return "newsong";
	}

	@PostMapping("/admin")
	public String getHome(HttpSession session) {
		session.invalidate();
		return "admin";

	}

	@GetMapping("/viewsongs")
	public String viewsongs(Model model,HttpSession session) {
		List<Song> songList = SongService.fetchAllSongs();
		model.addAttribute("songs", songList);
		session.invalidate();
		return "displaysongs";
	}
}