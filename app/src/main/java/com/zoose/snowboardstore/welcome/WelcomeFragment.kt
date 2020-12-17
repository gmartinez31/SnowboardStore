package com.zoose.snowboardstore.welcome

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.findNavController
import com.zoose.snowboardstore.R
import com.zoose.snowboardstore.databinding.WelcomeFragmentBinding

class WelcomeFragment : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding: WelcomeFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.welcome_fragment, container, false)

        binding.instructionBtn.setOnClickListener {
            findNavController().navigate(WelcomeFragmentDirections.actionWelcomeDestinationToInstructionDestination())
        }
        return binding.root
    }
}