package com.example.newsapplication.Fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.newsapplication.R

class HomeFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

       /* val adapter = NewsAdapterFragment(supportFragmentManager, lifecycle)
        homeBinding.viewPager.adapter = adapter

        TabLayoutMediator(homeBinding.tabLayout, homeBinding.viewPager){
                tab, position ->
            when(position){
                0 -> {
                    tab.text = "First"
                }
                1 -> {
                    tab.text = "Second"
                }
                2 -> {
                    tab.text = "Third"
                }
            }
        }.attach()
*/
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }


}