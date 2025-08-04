package edu.project.latihanparsingapipublic.domain.usecase

import edu.project.latihanparsingapipublic.data.remote.ResponseUser
import edu.project.latihanparsingapipublic.domain.repository.UserRepository
import javax.inject.Inject

class GetUserUseCase @Inject constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(): ResponseUser {
        return userRepository.getUsers()
    }
}