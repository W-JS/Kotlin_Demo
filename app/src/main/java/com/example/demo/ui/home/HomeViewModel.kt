package com.example.demo.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text

    private val _hintText = MutableLiveData<String>().apply {
        value = "提示"
    }
    val hintText: LiveData<String> = _hintText

    private val _jumpText = MutableLiveData<String>().apply {
        value = "跳转"
    }
    val jumpText: LiveData<String> = _jumpText
}