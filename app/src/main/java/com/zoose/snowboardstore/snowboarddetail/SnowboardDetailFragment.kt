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

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: SnowboardDetailFragmentBinding = DataBindingUtil.inflate(
                inflater, R.layout.snowboard_detail_fragment, container, false)

        binding.lifecycleOwner = this

        binding.cancelButton.setOnClickListener {
            findNavController().navigate(SnowboardDetailFragmentDirections.actionSnowboardDetailDestinationToSnowboardDestination(null, null, null, 0))
        }

        binding.saveButton.setOnClickListener {
            findNavController().navigate(
                    SnowboardDetailFragmentDirections.actionSnowboardDetailDestinationToSnowboardDestination(
                        binding.snowboardNameEditText.toString(),
                        binding.snowboardBrandEditText.text.toString(),
                        binding.snowboardDescriptionEditText.text.toString(),
                        binding.snowboardSizeEditText.text.toString().toInt()
                    )
            )
        }

        return binding.root
    }

}