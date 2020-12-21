package com.zoose.snowboardstore.snowboardlist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class SnowboardListViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SnowboardListViewModel::class.java)) {
            return SnowboardListViewModel() as T
        }
        throw IllegalArgumentException("Unknown viewmodel class")
    }
}