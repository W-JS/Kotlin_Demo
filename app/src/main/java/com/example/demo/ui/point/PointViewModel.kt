package com.example.demo.ui.point

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class PointViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is point Fragment"
    }
    val text: LiveData<String> = _text
}