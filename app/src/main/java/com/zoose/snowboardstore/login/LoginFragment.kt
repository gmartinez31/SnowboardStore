package com.zoose.snowboardstore.login

import android.opengl.Visibility
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import com.zoose.snowboardstore.R
import com.zoose.snowboardstore.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    private lateinit var viewModel: LoginViewModel
    private lateinit var viewModelFactory: LoginViewModelFactory

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val binding: LoginFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.login_fragment, container, false)

        viewModelFactory = LoginViewModelFactory()
        viewModel = ViewModelProvider(this, viewModelFactory).get(LoginViewModel::class.java)
        binding.loginViewModel = viewModel

        binding.lifecycleOwner = this

        viewModel.createAccountEvent.observe(viewLifecycleOwner, Observer {
            createAccount -> if (createAccount) {
                showConfirmPasswordFields(binding)
            }
        })

        viewModel.loginToAccountEvent.observe(viewLifecycleOwner, Observer {
            loginToAccount -> if (loginToAccount) {
                hideConfirmPasswordFields(binding)
            }
        })

        return binding.root
    }

    private fun hideConfirmPasswordFields(binding: LoginFragmentBinding) {
        binding.apply {
            confirmPasswordLabel.visibility = View.GONE
            confirmPasswordText.visibility = View.GONE
        }
    }

    private fun showConfirmPasswordFields(binding: LoginFragmentBinding) {
        binding.apply {
            confirmPasswordLabel.visibility = View.VISIBLE
            confirmPasswordText.visibility = View.VISIBLE
        }
    }

}