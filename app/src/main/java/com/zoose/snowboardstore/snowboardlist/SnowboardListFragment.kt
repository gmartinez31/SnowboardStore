package com.zoose.snowboardstore.snowboardlist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zoose.snowboardstore.R

class SnowboardListFragment : Fragment() {

    companion object {
        fun newInstance() = SnowboardListFragment()
    }

    private lateinit var viewModel: SnowboardListViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.shoe_list_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SnowboardListViewModel::class.java)
        // TODO: Use the ViewModel
    }

}