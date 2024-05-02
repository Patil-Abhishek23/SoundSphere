package com.kodnest.soundsphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kodnest.soundsphere.entity.PlayList;

public interface PlayListRepository extends JpaRepository<PlayList, Integer> {

}
