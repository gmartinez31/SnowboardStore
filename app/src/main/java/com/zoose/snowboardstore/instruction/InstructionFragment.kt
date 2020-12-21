package com.zoose.snowboardstore.instruction

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.zoose.snowboardstore.R
import com.zoose.snowboardstore.databinding.InstructionFragmentBinding

class InstructionFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val binding: InstructionFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.instruction_fragment, container, false)

        binding.snoboardListBtn.setOnClickListener {
            findNavController().navigate(InstructionFragmentDirections.actionInstructionDestinationToSnowboardListFragment())
        }

        return binding.root
    }

}