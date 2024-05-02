package com.kodnest.soundsphere.service;

import java.util.List;

import com.kodnest.soundsphere.entity.Song;

public interface SongService {

	public String addSong(Song song);

	public List<Song> fetchAllSongs();
	
	public void UpdateSong(Song s);

}
