package io.rienel.practice78.client

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import io.rienel.practice78.client.databinding.ActivityMainBinding

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

	// private ActivityMainBinding binding;
	private lateinit var binding: ActivityMainBinding

	private val viewModel: MainViewModel by viewModels()

	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		binding = ActivityMainBinding.inflate(layoutInflater)
		val view = binding.root
		setContentView(view)
		val adapter: SongListAdapter = SongListAdapter(mutableListOf())
		binding.songRecyclerView.layoutManager = LinearLayoutManager(this@MainActivity)
		binding.songRecyclerView.adapter = adapter
		viewModel.songs.observe(this) { songs ->
			if (songs == null) {
				Toast.makeText(this@MainActivity, R.string.request_failed, Toast.LENGTH_SHORT)
					.show()
				return@observe
			}
			(binding.songRecyclerView.adapter as SongListAdapter).updateSongsList(songs)
		}
		binding.button.setOnClickListener {
			viewModel.addNewSongs()
		}
		viewModel.getSongs()
	}
}