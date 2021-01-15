package com.zoose.snowboardstore.snowboarddetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.zoose.snowboardstore.R
import com.zoose.snowboardstore.databinding.SnowboardDetailFragmentBinding

class SnowboardDetailFragment : Fragment() {

    private lateinit var viewModel: SnowboardDetailViewModel
    private lateinit var viewModelFactory: SnowboardDetailViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: SnowboardDetailFragmentBinding = DataBindingUtil.inflate(
                inflater, R.layout.snowboard_detail_fragment, container, false)
        viewModelFactory = SnowboardDetailViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(SnowboardDetailViewModel::class.java)

        binding.snowboardDetailViewModel = viewModel
        binding.lifecycleOwner = this



        return inflater.inflate(R.layout.snowboard_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SnowboardDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}