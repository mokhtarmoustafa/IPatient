package com.twoam.ipatient.ui.home

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.twoam.ipatient.R

class CreatePrescriptionFragment : Fragment() {

    companion object {
        fun newInstance() = CreatePrescriptionFragment()
    }

    private lateinit var viewModel: CreatePrescriptionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.create_prescription_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(CreatePrescriptionViewModel::class.java)
        // TODO: Use the ViewModel
    }

}