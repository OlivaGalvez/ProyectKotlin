package com.galvez.oliva.gangame

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.view.MenuItem
import com.galvez.oliva.gangame.deals.DealsFragment
import com.galvez.oliva.gangame.owned.TopOwnedFragment
import com.galvez.oliva.gangame.rated.TopRatedFragment

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val DEFAULT_OPTIONS = R.id.action_deals
    }

    val fragments: HashMap<Int, Fragment> = hashMapOf(
            Pair(R.id.action_top_rated, TopRatedFragment()),
            Pair(R.id.action_most_owned, TopOwnedFragment()),
            Pair(R.id.action_deals, DealsFragment())
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()

        navigationView.selectedItemId = DEFAULT_OPTIONS
        navigationView.setOnNavigationItemSelectedListener {item ->
            val fragment: Fragment? = fragments[item.itemId]
            if (fragment != null) {
                replaceFragment(fragment)
            }
            true
        }
    }

    fun initView() {
        val currentFragment = supportFragmentManager
                .findFragmentById(R.id.fragmentContainer)

        if (currentFragment == null)
            supportFragmentManager
                    .beginTransaction()
                    .add(R.id.fragmentContainer, fragments[DEFAULT_OPTIONS])
                    .commit()
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit()
    }
}
