package com.zoose.snowboardstore.snowboarddetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zoose.snowboardstore.R

class SnowboardDetailFragment : Fragment() {

    companion object {
        fun newInstance() = SnowboardDetailFragment()
    }

    private lateinit var viewModel: SnowboardDetailViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.shoe_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SnowboardDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}