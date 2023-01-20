package com.example.projectmitrainsyirah.vPagerFragment.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.projectmitrainsyirah.R
import com.example.projectmitrainsyirah.databinding.FragmentLandingPage3Binding

class LandingPage3 : Fragment() {
    private lateinit var binding : FragmentLandingPage3Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_landing_page3,
            container, false)
        binding = FragmentLandingPage3Binding.bind(view)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.button3.setOnClickListener{
            viewPager?.currentItem = 3
        }
        return view
    }
}