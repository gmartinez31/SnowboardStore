package com.zoose.snowboardstore.snowboarddetail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
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

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(SnowboardDetailFragmentDirections.actionSnowboardDetailDestinationToSnowboardDestination(null, null, null, 0));
        }

        binding.saveButton.setOnClickListener {
            // save new snowboard and pass as bundle to snowboard list fragment
//            viewModel.newSnowboard.value?.apply {
//                brand = binding.snowboardBrandEditText.text.toString()
//                description = binding.snowboardDescriptionEditText.text.toString()
//                size = binding.snowboardSizeEditText.text.toString().toInt()
//                name = binding.snowboardNameEditText.text.toString()
//            }
            findNavController().navigate(
                    SnowboardDetailFragmentDirections.actionSnowboardDetailDestinationToSnowboardDestination(
                        binding.snowboardNameEditText.toString(),
                        binding.snowboardBrandEditText.text.toString(),
                        binding.snowboardDescriptionEditText.text.toString(),
                        binding.snowboardSizeEditText.text.toString().toInt()
                    )
            )
        }

        return inflater.inflate(R.layout.snowboard_detail_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(SnowboardDetailViewModel::class.java)
        // TODO: Use the ViewModel
    }

}