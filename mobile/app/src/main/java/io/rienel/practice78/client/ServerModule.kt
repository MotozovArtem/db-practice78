package io.rienel.practice78.client

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Authenticator
import okhttp3.Credentials
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
class ServerModule {

	@Provides
	fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
		.authenticator { route, response ->
			val request = response.request()
			if (request.header("Authorization") != null) {
				return@authenticator request
			}
			return@authenticator request.newBuilder()
				.header("Authorization",
					Credentials.basic("admin", "adminPass"))
				.build()
		}
		.build()

	@Provides
	fun provideRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
		.client(okHttpClient)
		.addConverterFactory(JacksonConverterFactory.create())
		.baseUrl("http://172.20.10.2:8080")
		.build()

	@Provides
	fun provideServerService(retrofit: Retrofit) = retrofit.create(ServerService::class.java)
}