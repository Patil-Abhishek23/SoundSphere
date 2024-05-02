package com.kodnest.soundsphere.serviceimplimentation;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.kodnest.soundsphere.entity.Song;
import com.kodnest.soundsphere.repository.SongRepository;
import com.kodnest.soundsphere.service.SongService;

@Service
public class SongServiceImpl implements SongService {

	@Autowired
	SongRepository SongRepository;

	@SuppressWarnings("null")
	@Override
	public String addSong(Song song) {

		SongRepository.save(song);

		return "Song has beeen added";

	}

	public String getHome() {
		return "admin";
	}

	@Override
	public List<Song> fetchAllSongs() {
		List<Song> songs = SongRepository.findAll();
		return songs;
	}


	@SuppressWarnings("null")
	@Override
	public void UpdateSong(Song s) {
		SongRepository.save(s);

	}

}
