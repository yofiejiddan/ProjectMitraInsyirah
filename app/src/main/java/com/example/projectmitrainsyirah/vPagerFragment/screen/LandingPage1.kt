package com.example.projectmitrainsyirah.vPagerFragment.screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.widget.ViewPager2
import com.example.projectmitrainsyirah.R
import com.example.projectmitrainsyirah.databinding.FragmentLandingPage1Binding


class LandingPage1 : Fragment() {
    private lateinit var binding : FragmentLandingPage1Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_landing_page1,
            container, false)
        binding = FragmentLandingPage1Binding.bind(view)
        val viewPager = activity?.findViewById<ViewPager2>(R.id.viewPager)

        binding.buttonNext.setOnClickListener{
            viewPager?.currentItem = 1
        }
        return view
    }
}