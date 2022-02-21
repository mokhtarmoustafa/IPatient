package com.twoam.ipatient.ui.home

import android.opengl.Visibility
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import com.twoam.ipatient.R
import com.twoam.ipatient.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {

    //region variables

    private lateinit var viewModel: HomeViewModel
    private lateinit var binding: HomeFragmentBinding
    //endregion

    companion object {
        fun newInstance() = HomeFragment()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.findViewById<Group>(R.id.group_top_data)?.visibility = View.VISIBLE
    }

    //region events
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewModel = ViewModelProvider(this)[HomeViewModel::class.java]
        binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showEmptyView(true)
    }


    //endregion

    //region helper functions

    private fun showEmptyView(isEmpty: Boolean) {
        if (isEmpty) binding.groupEmptyData.visibility = View.VISIBLE else View.INVISIBLE
    }
    //endregion

}