package edu.project.latihanparsingapipublic.presentation.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import edu.project.latihanparsingapipublic.data.remote.ResponseUser
import edu.project.latihanparsingapipublic.domain.usecase.GetUserUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getUserUseCase: GetUserUseCase
) : ViewModel() {

    private val _users = MutableLiveData<ResponseUser>()
    val users: LiveData<ResponseUser> = _users

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    fun getUsers() {
        _isLoading.value = true
        viewModelScope.launch {
            try {
                val response = getUserUseCase()
                _users.value = response
            } catch (e: Exception) {
                // Handle error
            } finally {
                _isLoading.value = false
            }
        }
    }
}