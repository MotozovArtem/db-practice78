package com.example.demo.controller;

import java.util.List;

import com.example.demo.model.Song;
import com.example.demo.repository.SongRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO ArMotozov
 *
 * @since 11/26/2022
 */
@RestController
@RequestMapping("/api/v1/song")
public class SongController {

	@Autowired
	private SongRepository songRepository;

	@GetMapping("/")
	public List<Song> getAllSongs() {
		return songRepository.findAll();
	}
}
