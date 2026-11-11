package com.example.lab1.ViewModels

import androidx.lifecycle.ViewModel
import com.example.lab1.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class DogViewModel: ViewModel() {

    private val _dogs = listOf("Лабратор", "такса", "Пікінес")
    private val _images = listOf(R.drawable.dog1,R.drawable.dog2,R.drawable.dog3)
    private var _currentIndx: Int = 0;
    private val _currentDog = MutableStateFlow<String>(_dogs.get(_currentIndx))
    val CurrentDog: StateFlow<String> = _currentDog.asStateFlow()

    private val _currentDogImage = MutableStateFlow<Int>(_images.get(_currentIndx))
    val CurrentDogImage: StateFlow<Int> = _currentDogImage.asStateFlow()

    public fun changeDog() {
        _currentIndx=(_currentIndx+1)%3
        _currentDog.value = _dogs.get(_currentIndx)
        _currentDogImage.value = _images.get(_currentIndx)

    }

}