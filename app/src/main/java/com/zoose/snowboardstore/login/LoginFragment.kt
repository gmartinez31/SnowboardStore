package com.zoose.snowboardstore.login

import android.opengl.Visibility
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.text.Editable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
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

        viewModel.loggedIn.observe(viewLifecycleOwner, Observer {
            loggedIn -> if (loggedIn) {
                // validate login pw OR validate pw match if creating account
                validateLogin(binding)
                // navigate to onboarding page
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

    private fun validateLogin(binding: LoginFragmentBinding) {
        if (viewModel.createAccountEvent.value == true) {
            if (validateEmailAndPasswords(binding) && passwordsMatch(binding.passwordText.text, binding.confirmPasswordText.text)) {
                // navigate to welcome screen
                // also remember that this user is now "logged in" so maybe we need a userLoggedIn boolean field in the viewmodel
            } else {
                //show error message
            }
        } else {
            if (validateEmailAndPassword(binding)) {
                // "log in" and navigate to welcome screen
            }
            // show error message
        }
        binding.emailText.text
        binding.passwordText.text
        binding.confirmPasswordText.text
    }

    private fun validateEmailAndPassword(binding: LoginFragmentBinding): Boolean {
        return binding.emailText.text.isNotEmpty() && binding.passwordText.text.isNotEmpty()
    }

    private fun validateEmailAndPasswords(binding: LoginFragmentBinding): Boolean {
        return binding.emailText.text.isNotEmpty() && binding.passwordText.text.isNotEmpty() && binding.confirmPasswordText.text.isNotEmpty()
    }

    private fun passwordsMatch(password: Editable, confirmPassword: Editable): Boolean {
        return password == confirmPassword
    }
}