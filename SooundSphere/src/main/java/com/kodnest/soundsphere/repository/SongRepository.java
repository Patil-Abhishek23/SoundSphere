package com.kodnest.soundsphere.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import com.kodnest.soundsphere.entity.Song;
import jakarta.transaction.Transactional;

public interface SongRepository extends JpaRepository<Song, Integer> {

	Song findByName(String name);

	@Transactional
	@Modifying
	@Query("DELETE FROM Song s WHERE s.link IS NULL")
	void deleteSongsWithNullLink();

}
