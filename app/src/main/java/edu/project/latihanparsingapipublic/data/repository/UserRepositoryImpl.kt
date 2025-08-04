package edu.project.latihanparsingapipublic.data.repository

import edu.project.latihanparsingapipublic.data.remote.ApiConfig
import edu.project.latihanparsingapipublic.data.remote.ApiService
import edu.project.latihanparsingapipublic.data.remote.ResponseUser
import edu.project.latihanparsingapipublic.domain.repository.UserRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : UserRepository {

    override suspend fun getUsers(): ResponseUser {
        return apiService.getUsers(ApiConfig.getApiKey())
    }
}