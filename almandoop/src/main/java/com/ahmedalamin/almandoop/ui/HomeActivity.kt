package com.ahmedalamin.almandoop.ui


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.ahmedalamin.almandoop.R
import com.ahmedalamin.almandoop.fragment.SaleFragment
import com.ahmedalamin.almandoop.fragment.HomeFragment
import com.ahmedalamin.almandoop.fragment.PriceListFragment
import com.ahmedalamin.almandoop.fragment.SettingFragment

import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationBarView


class HomeActivity : AppCompatActivity() {
    var bottomNavigationView: BottomNavigationView? = null
    var homeFragment: HomeFragment = HomeFragment()
    var searchFragment: PriceListFragment = PriceListFragment()
    var saleFragment: SaleFragment = SaleFragment()
    var settingFragment: SettingFragment = SettingFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottom_Navigation)
        supportFragmentManager.beginTransaction().replace(R.id.container, homeFragment).commit()
        bottomNavigationView!!.setOnItemSelectedListener(NavigationBarView.OnItemSelectedListener { itemId ->
            when (itemId.itemId) {
                R.id.home -> {
                    supportFragmentManager.beginTransaction().replace(R.id.container, homeFragment)
                        .commit()
                    return@OnItemSelectedListener true
                }
                R.id.favorite -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, saleFragment).commit()
                    return@OnItemSelectedListener true
                }
                R.id.search -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, searchFragment).commit()
                    return@OnItemSelectedListener true
                }
                R.id.setting -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, settingFragment).commit()
                    return@OnItemSelectedListener true
                }
            }
            false
        })
    }
}
