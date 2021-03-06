package com.twoam.ipatient.ui.auth

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.transition.TransitionInflater
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.twoam.ipatient.R
import com.twoam.ipatient.databinding.RegisterFragmentBinding

class RegisterFragment : Fragment() {
    //region  variables
    private lateinit var viewModel: RegisterViewModel
    private lateinit var binding: RegisterFragmentBinding
    //endregion

    companion object {
        fun newInstance() = RegisterFragment()
    }

    //region events
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        sharedElementEnterTransition = TransitionInflater.from(requireContext()).inflateTransition(android.R.transition.move)
        viewModel = ViewModelProvider(this)[RegisterViewModel::class.java]
        binding = RegisterFragmentBinding.inflate(layoutInflater, container, false)
        loadAgeData()
        loadRelativeData()

        binding.toolbar.setNavigationOnClickListener {
            findNavController().navigateUp()
        }
        return binding.root
    }


    //endregion

    //region helper functions
    private fun loadAgeData() {
        val ageAdapter = ArrayAdapter(
            requireContext(),
            R.layout.custom_text_view_age,
            resources.getStringArray(R.array.gender)
        )
        binding.acGender.setAdapter(ageAdapter)
        binding.acGender.setAdapter(ageAdapter)
    }
    private fun loadRelativeData() {
        val ageAdapter = ArrayAdapter(
            requireContext(),
            R.layout.custom_text_view_age,
            resources.getStringArray(R.array.relative_degree)
        )
        binding.acUserType.setAdapter(ageAdapter)
        binding.acUserType.setAdapter(ageAdapter)
    }
    //endregion


}