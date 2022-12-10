package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

/**
 * TODO ArMotozov
 *
 * @since 11/26/2022
 */

@Entity
@Table(name = "playlist")
public class Playlist {
	@Id
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "song_count", nullable = false)
	private Integer songCount;

	@ManyToOne(targetEntity = User.class, fetch = FetchType.EAGER, optional = false)
	@JoinColumn(name = "userid", nullable = false)
	private User user;

	public Playlist() {
	}

	public Playlist(Integer id, String name, Integer songCount, User user) {
		this.id = id;
		this.name = name;
		this.songCount = songCount;
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSongCount() {
		return songCount;
	}

	public void setSongCount(Integer songCount) {
		this.songCount = songCount;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
