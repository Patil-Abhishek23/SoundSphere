package com.kodnest.soundsphere.serviceimplimentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kodnest.soundsphere.entity.PlayList;
import com.kodnest.soundsphere.repository.PlayListRepository;
import com.kodnest.soundsphere.service.PlayListService;

@Service
public class PlayListServiceImpl implements PlayListService {

	@Autowired
	PlayListRepository PlayListRepository;

	@SuppressWarnings("null")
	@Override
	public void addplaylist(PlayList playList) {
		PlayListRepository.save(playList);

	}

	@Override
	public List<PlayList> fetchAllPlaylist() {
		List<PlayList> Allplaylist=	PlayListRepository.findAll();
		return Allplaylist;
	}

	
}
