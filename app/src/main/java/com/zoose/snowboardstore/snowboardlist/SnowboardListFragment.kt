package com.zoose.snowboardstore.snowboardlist

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.zoose.snowboardstore.R
import com.zoose.snowboardstore.databinding.SnowboardListFragmentBinding
import com.zoose.snowboardstore.login.LoginViewModelFactory
import com.zoose.snowboardstore.models.Snowboard

class SnowboardListFragment : Fragment() {

    private lateinit var viewModel: SnowboardListViewModel
    private lateinit var viewModelFactory: SnowboardListViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: SnowboardListFragmentBinding = DataBindingUtil.inflate(
                inflater, R.layout.snowboard_list_fragment, container, false)

        binding.addSnowboardButton.setOnClickListener {
            Toast.makeText(context, "Add Snowboard Button clicked.", Toast.LENGTH_LONG).show()
            findNavController().navigate(SnowboardListFragmentDirections.actionSnowboardListFragmentToSnowboardDetailFragment())
        }

        viewModelFactory = SnowboardListViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(SnowboardListViewModel::class.java)
        binding.snowboardListViewModel = viewModel

        val args = SnowboardListFragmentArgs.fromBundle(requireArguments())
        val newSnowboard = Snowboard(
                args.newSnowboardName.toString(),
                args.newSnowboardSize,
                args.newSnowboardBrand.toString(),
                args.newSnowboardDescription.toString()
        )

        viewModel.addToSnowboardList(newSnowboard)
        binding.lifecycleOwner = this

        return inflater.inflate(R.layout.snowboard_list_fragment, container, false)
    }

}