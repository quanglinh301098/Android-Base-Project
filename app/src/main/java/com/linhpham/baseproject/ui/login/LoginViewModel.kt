package com.linhpham.baseproject.ui.login

import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.linhpham.baseproject.base.BaseFragmentVM
import com.linhpham.baseproject.data.user.entity.User
import com.linhpham.baseproject.data.user.repository.UserRepository
import com.linhpham.baseproject.model.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(val userRepository: UserRepository) : BaseFragmentVM() {

    fun login(user: User) = liveData<Resource<User>>{
        viewModelScope.launch {
           emit(Resource.loading())
            emit(Resource.success(userRepository.login(user)))
        }
    }
}