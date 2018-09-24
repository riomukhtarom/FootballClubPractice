package com.gdk.rio.footballclubpractice.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.gdk.rio.footballclubpractice.FavoriteTeamsFragment
import com.gdk.rio.footballclubpractice.R
import com.gdk.rio.footballclubpractice.R.id.favorites
import com.gdk.rio.footballclubpractice.R.id.teams
import com.gdk.rio.footballclubpractice.TeamsFragment
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        bottom_navigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                teams -> {
                    loadTeamsFragment(savedInstanceState)
                }

                favorites -> {
                    loadFavoritesFragment(savedInstanceState)
                }
            }

            true
        }

        bottom_navigation.selectedItemId = teams
    }

    private fun loadTeamsFragment(savedInstanceState: Bundle?){
        if(savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, TeamsFragment(), TeamsFragment::class.java.simpleName)
                    .commit()
        }
    }

    private fun loadFavoritesFragment(savedInstanceState: Bundle?){
        if(savedInstanceState == null) {
            supportFragmentManager
                    .beginTransaction()
                    .replace(R.id.main_container, FavoriteTeamsFragment(), FavoriteTeamsFragment::class.java.simpleName)
                    .commit()
        }
    }
}
