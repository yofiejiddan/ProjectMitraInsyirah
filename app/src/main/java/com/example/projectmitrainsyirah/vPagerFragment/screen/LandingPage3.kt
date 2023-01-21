package com.example.projectmitrainsyirah.vPagerFragment.screen

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.projectmitrainsyirah.R
import com.example.projectmitrainsyirah.databinding.FragmentLandingPage3Binding

class LandingPage3 : Fragment() {
    private  lateinit var  binding : FragmentLandingPage3Binding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_landing_page3,
            container, false)

        binding = FragmentLandingPage3Binding.bind(view)


        binding.button3.setOnClickListener{
            findNavController().navigate(R.id.action_viewPagerFragment_to_loginAplikasi2)

        }
        return view
    }

    private fun onBoardingFinished(){
        val sharedPref = requireActivity().getSharedPreferences("onBoarding", Context.MODE_PRIVATE)
        val editor = sharedPref.edit()
        editor.putBoolean("Selesai", true)
        editor.apply()
    }

}