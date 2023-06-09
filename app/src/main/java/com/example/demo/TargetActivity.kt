package com.example.demo

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.demo.base.Config
import com.example.demo.databinding.ActivityTargetBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class TargetActivity : AppCompatActivity() {

    private val TAG: String = Config.BASE_TAG + TargetActivity::class.java.simpleName

    private lateinit var binding: ActivityTargetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d(TAG, "onCreate: ")
        super.onCreate(savedInstanceState)

        binding = ActivityTargetBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView: BottomNavigationView = binding.navView

        val navController = findNavController(R.id.nav_host_fragment_activity_target)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications, R.id.navigation_point
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onResume() {
        Log.d(TAG, "onResume: ")
        super.onResume()
        Toast.makeText(this, "Enter ${TargetActivity::class.java.simpleName}", Toast.LENGTH_SHORT)
            .show()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy: ")
        super.onDestroy()
    }
}