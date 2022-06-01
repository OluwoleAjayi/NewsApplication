package com.example.newsapplication.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.newsapplication.Fragment.BookmarkFragment
import com.example.newsapplication.Fragment.HomeFragment
import com.example.newsapplication.Fragment.ProfileFragment
import com.example.newsapplication.Fragment.SearchFragment


class NewsAdapterFragment(fragmentManager: FragmentManager, lifecycle: Lifecycle) : FragmentStateAdapter(fragmentManager, lifecycle){
    override fun getItemCount(): Int {
        return 9

    }

    override fun createFragment(position: Int): Fragment {
        return when(position){
            0 -> {
                HomeFragment()
            }
            1 -> {
                SearchFragment()
            }
            2 -> {
                BookmarkFragment()
            }
            else -> {
                ProfileFragment()
            }
        }

    }


}



