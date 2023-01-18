package com.example.projectmitrainsyirah

import android.content.Context
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController

class SplashScreenFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Handler(Looper.getMainLooper()).postDelayed({
            if (!onBoardingFinished()) {
                findNavController().navigate(
                    R.id.action_splashScreenFragment3_to_halamanUtamaFragment
                )
            } else {
                findNavController().navigate(
                    R.id.action_splashScreenFragment3_to_viewPagerFragment
                )
            }
        },3000)
        return inflater.inflate(R.layout.fragment_splash_screen, container, false)
    }
    private fun onBoardingFinished(): Boolean{
        val sharedPref = requireActivity()
            .getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        return sharedPref.getBoolean("Selesai", false)
    }
}