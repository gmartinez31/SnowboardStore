package com.zoose.snowboardstore.snowboarddetail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.zoose.snowboardstore.snowboardlist.SnowboardListViewModel
import java.lang.IllegalArgumentException

class SnowboardDetailViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SnowboardDetailViewModel::class.java)) {
            return SnowboardDetailViewModel() as T
        }
        throw IllegalArgumentException("Unknown viewmodel class")
    }
}