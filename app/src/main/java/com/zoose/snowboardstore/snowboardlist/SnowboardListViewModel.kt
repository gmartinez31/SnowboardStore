package com.zoose.snowboardstore.snowboardlist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.zoose.snowboardstore.models.Snowboard

class SnowboardListViewModel : ViewModel() {

    private val _snowboards = MutableLiveData<MutableList<Snowboard>>()
    val snowboards: LiveData<MutableList<Snowboard>> get() = _snowboards

    private val _listUpdated = MutableLiveData<Boolean>()
    val listUpdated: LiveData<Boolean> get() = _listUpdated

    init {
        snowboards.value?.add(Snowboard("Example", 150, "No Brand", "Test Board", listOf("image1")))
        _listUpdated.value = false
    }

    fun addToSnowboardList(snowboard: Snowboard) {
        _snowboards.value?.add(snowboard)
        listUpdatedEvent()
    }

    private fun listUpdatedEvent() {
        _listUpdated.value = true
    }

    fun onListUpdatedEventComplete() {
        _listUpdated.value = false
    }

}