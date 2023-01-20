package com.example.projectmitrainsyirah.vPagerFragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.projectmitrainsyirah.vPagerFragment.screen.HalamanUtamaFragment
import com.example.projectmitrainsyirah.R
import com.example.projectmitrainsyirah.databinding.FragmentViewPagerBinding
import com.example.projectmitrainsyirah.vPagerFragment.screen.LandingPage1
import com.example.projectmitrainsyirah.vPagerFragment.screen.LandingPage2
import com.example.projectmitrainsyirah.vPagerFragment.screen.LandingPage3

class ViewPagerFragment : Fragment() {
    lateinit var binding: FragmentViewPagerBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager,
            container, false)
        binding = FragmentViewPagerBinding.bind(view)
        val fragmentList = arrayListOf(
            LandingPage1(),
            LandingPage2(),
            LandingPage3(),
            HalamanUtamaFragment(),
        )
        val adapter = ViewPagerAdapter(fragmentList,
            requireActivity().supportFragmentManager, lifecycle)
        binding.viewPager.adapter = adapter
        return view
    }
}