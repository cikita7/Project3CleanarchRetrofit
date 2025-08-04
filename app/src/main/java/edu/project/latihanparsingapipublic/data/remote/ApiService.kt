package edu.project.latihanparsingapipublic.data.remote

import edu.project.latihanparsingapipublic.data.remote.ResponseUser
import retrofit2.http.*

interface ApiService {
    @GET("api/users")
    suspend fun getUsers(
        @Query("api_key") apiKey: String
    ): ResponseUser
}