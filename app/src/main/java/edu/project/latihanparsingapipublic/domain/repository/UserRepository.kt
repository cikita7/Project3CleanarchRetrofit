package edu.project.latihanparsingapipublic.domain.repository

import edu.project.latihanparsingapipublic.data.remote.ResponseUser

interface UserRepository {
    suspend fun getUsers(): ResponseUser
}