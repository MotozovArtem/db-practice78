package io.rienel.practice78.client

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dagger.hilt.android.lifecycle.HiltViewModel
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
	private val serverService: ServerService
): ViewModel() {

	private val TAG = "MainViewModel"

	fun getSongs(): LiveData<List<Song>?> {
		return liveData {
			val response: Response<List<Song>>
			try {
				response = serverService.getSongList()
			} catch (e: Exception) {
				Log.e(TAG, "Error while requesting songs", e)
				emit(null)
				return@liveData
			}
			val song: List<Song>? = response.body()
			if (song == null) {
				emit(listOf())
			} else {
				emit(song)
			}
			return@liveData
		}
	}
}