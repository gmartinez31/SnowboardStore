package com.zoose.snowboardstore.snowboardlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zoose.snowboardstore.models.Snowboard

class SnowboardListViewModel : ViewModel() {

    private val _snowboards = MutableLiveData<MutableList<Snowboard>>()
    val snowboards: LiveData<MutableList<Snowboard>> get() = _snowboards

    init {
        snowboards.value?.add(Snowboard("Example", 150, "No Brand", "Test Board", listOf("image1")))
    }

}