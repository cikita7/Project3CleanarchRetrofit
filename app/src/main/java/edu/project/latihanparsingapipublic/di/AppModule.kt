package edu.project.latihanparsingapipublic.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import edu.project.latihanparsingapipublic.data.remote.ApiConfig
import edu.project.latihanparsingapipublic.data.remote.ApiService
import edu.project.latihanparsingapipublic.data.repository.UserRepositoryImpl
import edu.project.latihanparsingapipublic.domain.repository.UserRepository
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideApiService(): ApiService {
        return ApiConfig.getApiService()
    }

    @Provides
    @Singleton
    fun provideUserRepository(apiService: ApiService): UserRepository {
        return UserRepositoryImpl(apiService)
    }
}