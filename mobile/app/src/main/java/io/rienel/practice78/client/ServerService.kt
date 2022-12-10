package io.rienel.practice78.client

import retrofit2.Response
import retrofit2.http.GET

interface ServerService {
	@GET("/api/v1/song/")
	suspend fun getSongList(): Response<List<Song>>
}