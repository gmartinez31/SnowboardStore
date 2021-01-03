package com.zoose.snowboardstore.snowboardlist

import androidx.lifecycle.ViewModel
import com.zoose.snowboardstore.models.Snowboard

class SnowboardListViewModel : ViewModel() {

    val snowboardList = mutableListOf<Snowboard>()

    init {
        snowboardList.add(Snowboard("Example", 150, "No Brand", "Test Board", listOf("image1")))
    }

}