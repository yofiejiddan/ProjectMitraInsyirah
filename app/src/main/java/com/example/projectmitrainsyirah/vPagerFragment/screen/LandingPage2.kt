package com.example.projectmitrainsyirah.vPagerFragment.screen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.widget.ViewPager2
import com.example.projectmitrainsyirah.R
import com.example.projectmitrainsyirah.databinding.FragmentLandingPage2Binding

class LandingPage2 : Fragment() {
    private lateinit var binding : FragmentLandingPage2Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_landing_page2,
            container, false)
        binding = FragmentLandingPage2Binding.bind(view)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.button2.setOnClickListener{
            viewPager?.currentItem = 2
        }
        return view
    }
}