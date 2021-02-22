package com.zoose.snowboardstore.snowboarddetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zoose.snowboardstore.models.Snowboard

class SnowboardDetailViewModel : ViewModel() {

    private val _newSnowboard = MutableLiveData<Snowboard>()
    val newSnowboard: LiveData<Snowboard> get() = _newSnowboard

    init {

    }

    fun addNewBoard() {

    }
}