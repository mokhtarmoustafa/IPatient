package com.twoam.ipatient.ui.splash

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.navigation.NavigationView
import com.twoam.ipatient.R
import com.twoam.ipatient.databinding.FragmentSplashBinding


class SplashFragment : Fragment() {
    //region Variables
    private lateinit var binding: FragmentSplashBinding
     private val duration=1500L
    //endregion

    //region Events
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSplashBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navigate()
    }

    //endregion Helper FUnctions
    private fun navigate() {

        object : CountDownTimer(duration, 1000) {
            override fun onTick(p0: Long) {
            }

            override fun onFinish() {
                if (true) {
                    Log.d(TAG, "onFinish: ")
                    findNavController().navigate(R.id.action_splashFragment_to_homeFragment)
                } else {
                    findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
                }
            }
        }.start()

    }

    //region
    companion object {
        private const val TAG = "SplashFragment"
    }
}