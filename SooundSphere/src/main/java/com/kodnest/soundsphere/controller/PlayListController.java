package com.kodnest.soundsphere.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import com.kodnest.soundsphere.entity.PlayList;
import com.kodnest.soundsphere.entity.Song;
import com.kodnest.soundsphere.service.PlayListService;
import com.kodnest.soundsphere.service.SongService;

import jakarta.servlet.http.HttpSession;

@Controller
public class PlayListController {

	@Autowired
	SongService SongService;

	@Autowired
	PlayListService PlayListService;

	@GetMapping("/createplayList")
	public String createplayList(Model model,HttpSession session) {
		List<Song> songList = SongService.fetchAllSongs();
		model.addAttribute("songs", songList);
		session.invalidate();
		return "createplayList";
	}

	@PostMapping("/addplayList")
	public String addplaylist(@ModelAttribute PlayList PlayList,HttpSession session) {

		PlayListService.addplaylist(PlayList);

		List<Song> SongList = PlayList.getSongs();
		if (SongList != null) {
			for (Song s : SongList) {
				s.getPlaylists().add(PlayList);
				SongService.UpdateSong(s);
			}
		}
		session.invalidate();
		return "admin";
	}

	
	@GetMapping("/viewplaylist")
	public String viewplaylist(Model model,HttpSession session) {
		List<PlayList> Allplaylist = PlayListService.fetchAllPlaylist();
		model.addAttribute("Allplaylist", Allplaylist);
		session.invalidate();
		return "displayplaylist";
	}


}
