package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * TODO ArMotozov
 *
 * @since 11/26/2022
 */
@Entity
@Table(name = "song")
public class Song {
	@Id
	private Integer id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "length", nullable = false)
	private Integer length;

	@Column(name = "author_name", nullable = false)
	private String authorName;

	public Song() {
	}

	public Song(Integer id, String name, Integer length, String authorName) {
		this.id = id;
		this.name = name;
		this.length = length;
		this.authorName = authorName;
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

	public Integer getLength() {
		return length;
	}

	public void setLength(Integer length) {
		this.length = length;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
}
