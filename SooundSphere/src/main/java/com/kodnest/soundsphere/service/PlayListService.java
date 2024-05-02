package com.kodnest.soundsphere.service;

import java.util.List;

import com.kodnest.soundsphere.entity.PlayList;

public interface PlayListService {

	public List<PlayList> fetchAllPlaylist();

	public void addplaylist(PlayList playList);

}
