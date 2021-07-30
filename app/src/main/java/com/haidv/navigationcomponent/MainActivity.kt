package com.haidv.navigationcomponent

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var controller: NavController
    private var bottomNavigation: BottomNavigationView? = null
    private var floatingButton: FloatingActionButton? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        controller = findNavController(R.id.navHostFragment)

        floatingButton = findViewById(R.id.floatingButton)
        bottomNavigation = findViewById(R.id.bottomNavigation)
        bottomNavigation?.setupWithNavController(controller)
        bottomNavigation?.background = null

        floatingButton?.setOnClickListener {
            controller.navigate(R.id.newsFragment)
        }
    }

}