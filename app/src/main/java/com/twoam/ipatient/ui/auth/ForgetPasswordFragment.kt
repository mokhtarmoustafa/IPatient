package com.twoam.ipatient.ui.auth

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.twoam.ipatient.R
import com.twoam.ipatient.databinding.ForgetPasswordFragmentBinding

class ForgetPasswordFragment : Fragment() {

    companion object {
        fun newInstance() = ForgetPasswordFragment()
    }

    private lateinit var viewModel: ForgetPasswordViewModel
    private lateinit var binding: ForgetPasswordFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this).get(ForgetPasswordViewModel::class.java)
        binding = ForgetPasswordFragmentBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
    }

}