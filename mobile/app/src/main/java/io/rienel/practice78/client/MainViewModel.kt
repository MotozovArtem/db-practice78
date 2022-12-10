package io.rienel.practice78.client

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Response
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class MainViewModel @Inject constructor(
	private val serverService: ServerService
) : ViewModel() {

	private val TAG = "MainViewModel"

	val songs = MutableLiveData<MutableList<Song>>(mutableListOf())

	fun addNewSongs() {
		val newSong = Song(
			id = Random.nextInt(),
			name = "Name${Random.nextInt()}",
			length = Random.nextInt(100, 200),
			authorName = "AuthorName${Random.nextInt()}"
		)
		songs.value = mutableListOf(*songs.value!!.toTypedArray(), newSong)
	}

	fun getSongs() {
		viewModelScope.launch {
			val response: Response<List<Song>>
			try {
				response = serverService.getSongList()
			} catch (e: Exception) {
				Log.e(TAG, "Error while requesting songs", e)
				return@launch
			}
			val song: List<Song>? = response.body()
			if (song != null) {
				songs.value = mutableListOf(*songs.value!!.toTypedArray(), *song.toTypedArray())
			}
		}
	}
}