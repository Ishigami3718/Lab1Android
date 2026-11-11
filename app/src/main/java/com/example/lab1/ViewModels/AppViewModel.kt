package com.example.lab1.ViewModels

import androidx.lifecycle.ViewModel
import com.example.lab1.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class AppViewModel: ViewModel() {
    private val _cats = listOf("Сіамський", "Мейнкун", "Британець")
    private val _images = listOf(R.drawable.cat1,R.drawable.cat2,R.drawable.cat3)
    private var _currentIndx: Int = 0;
    private val _currentCat = MutableStateFlow<String>(_cats.get(_currentIndx))
    val CurrentCat: StateFlow<String> = _currentCat.asStateFlow()

    private val _currentCatImage = MutableStateFlow<Int>(_images.get(_currentIndx))
    val CurrentCatImage: StateFlow<Int> = _currentCatImage.asStateFlow()

    public fun changeCat() {
        _currentIndx=(_currentIndx+1)%3
        _currentCat.value = _cats.get(_currentIndx)
        _currentCatImage.value = _images.get(_currentIndx)

    }

}