package com.example.newsapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.newsapplication.Fragment.BookmarkFragment
import com.example.newsapplication.Fragment.HomeFragment
import com.example.newsapplication.Fragment.ProfileFragment
import com.example.newsapplication.Fragment.SearchFragment
import com.example.newsapplication.databinding.ActivityHomepageBinding

class HomepageActivity : AppCompatActivity() {

    private lateinit var homeBinding: ActivityHomepageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        homeBinding = DataBindingUtil.setContentView(this, R.layout.activity_homepage)



        val homeFragment = HomeFragment()
        val searchFragment = SearchFragment()
        val bookmarkFragment = BookmarkFragment()
        val profileFragment = ProfileFragment()

        setCurrentFragment(homeFragment)



        homeBinding.bottomNavigationView.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.homeFragment->setCurrentFragment(homeFragment)
                R.id.searchFragment -> setCurrentFragment(searchFragment)
                R.id.bookmarkFragment -> setCurrentFragment(bookmarkFragment)
                R.id.profileFragment ->setCurrentFragment(profileFragment)

            }
            true
        }
    }

    private fun setCurrentFragment(fragment: Fragment) =
        supportFragmentManager.beginTransaction().apply{
            replace(R.id.nav_Fragment, fragment)
            commit()

    }
}