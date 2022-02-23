package com.twoam.ipatient.ui.auth

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.transition.ChangeBounds
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.twoam.ipatient.R
import com.twoam.ipatient.databinding.LoginFragmentBinding

class LoginFragment : Fragment() {

    //region variables
    private lateinit var viewModel: LoginViewModel
    private lateinit var binding: LoginFragmentBinding

    //endregion
    companion object {
        fun newInstance() = LoginFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[LoginViewModel::class.java]
        binding = LoginFragmentBinding.inflate(layoutInflater, container, false)
        sharedElementEnterTransition = TransitionInflater.from(context).inflateTransition(android.R.transition.move)

//        sharedElementEnterTransition = ChangeBounds().apply {
//            duration = 750
//        }
//        sharedElementReturnTransition= ChangeBounds().apply {
//            duration = 750
//        }

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnLogin.setOnClickListener { if (validateAll()) login() }
        binding.tvRegister.setOnClickListener { register() }
        binding.tvForgetPassword.setOnClickListener { forgetPassword() }
    }

    private fun login() {
        val userName = binding.etUserName.text.toString()
        val password = binding.etPassword.text.toString()
        Toast.makeText(requireContext(), "Loggin", Toast.LENGTH_SHORT).show()
        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
    }

    private fun validateAll(): Boolean {
        when {
            binding.etUserName.text?.trim()!!.isEmpty() -> {
                Toast.makeText(requireContext(), "User Name can't be empty.", Toast.LENGTH_SHORT).show()
                binding.etUserName.requestFocus()
                return false
            }
            binding.etPassword.text?.trim()!!.isEmpty() -> {
                Toast.makeText(requireContext(), "Password can't be empty.", Toast.LENGTH_SHORT).show()
                binding.etPassword.requestFocus()
                return false
            }
            binding.etPassword.text?.trim()!!.length<6 -> {
                binding.etUserName.error = "Password can't be less than 6 digits."
                binding.etPassword.requestFocus()
                return false
            }
            else -> return true
        }
    }

    private fun register()
    {
        val extras = FragmentNavigatorExtras(
            binding.tiUserName to "transition_username",binding.tiPassword to "transition_password",binding.btnLogin to "transition_action")

        findNavController().navigate(R.id.action_loginFragment_to_registerFragment,null,null,extras)
    }
   private fun forgetPassword()
    {
        findNavController().navigate(R.id.action_loginFragment_to_forgetPasswordFragment)
    }


}