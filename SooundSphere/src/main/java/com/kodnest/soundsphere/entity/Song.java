package com.kodnest.soundsphere.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Song {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	int id;
	String name;
	String genre;
	String artist;
	String link;
	@ManyToMany
	List<PlayList> playlists;

	public Song(int id, String name, String genre, String artist, String link, List<PlayList> playlists) {
		super();
		this.id = id;
		this.name = name;
		this.genre = genre;
		this.artist = artist;
		this.link = link;
		this.playlists = playlists;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getArtist() {
		return artist;
	}

	public void setArtist(String artist) {
		this.artist = artist;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public List<PlayList> getPlaylists() {
		return playlists;
	}

	public void setPlaylists(List<PlayList> playlists) {
		this.playlists = playlists;
	}

	public Song() {
		super();
	}

	@Override
	public String toString() {
		return "Song [id=" + id + ", name=" + name + ", genre=" + genre + ", artist=" + artist + ", link=" + link
				+ ", playlists=" + playlists + "]";
	}

}
