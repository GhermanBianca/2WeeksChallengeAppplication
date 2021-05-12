package com.example.workouthome.activities

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.WindowInsets
import android.view.WindowManager
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.*
import com.bumptech.glide.Glide
import com.example.workouthome.R
import com.example.workouthome.firebase.FirestoreClass
import com.example.workouthome.fragments.AboutMeFragment
import com.example.workouthome.modules.User
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.nav_header_main.*

@Suppress("DEPRECATION")
class MainActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    companion object {
        const val MY_PROFILE_REQUEST_CODE: Int = 11
        private const val TAG = "MainActivity"

        // for update image and username in navigation_view from left
        fun updateNavigationUserDetails(mainActivity: MainActivity, user: User) {
            Log.d(TAG, "updateNavigationUserDetails")
            Glide
                .with(mainActivity)
                .load(user.image)
                .centerCrop()
                .placeholder(R.drawable.ic_user)
                .into(mainActivity.iv_user_image)

            mainActivity.tv_username.text = user.name
        }
    }

    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {

        Log.d(TAG, "MainActivity onCreate")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // show app full screen
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            window.insetsController?.hide(WindowInsets.Type.statusBars())
        } else {
            window.setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
            )
        }

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.findNavController()

        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.challengeFragment,
                R.id.exercisesFragment,
                R.id.adviceFragment,
                R.id.nutritionFragment
            ),
            drawer_layout
        )

        setSupportActionBar(toolbar)

        //for show menu button
        setupActionBarWithNavController(
            navController,
            appBarConfiguration
        )

        // for change fragments : Challange, Nutrition, etc
        bottom_nav.setupWithNavController(navController)
        // for open fragments: My Profile, Sign Out
        nav_view.setupWithNavController(navController)

        FirestoreClass().loadUserData(this)
    }

    // for work back and menu buttons
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

    // for update image from navigation_view
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK
            && requestCode == MY_PROFILE_REQUEST_CODE
        ) {
            // Get the user updated details.
            FirestoreClass().loadUserData(this@MainActivity)
        } else {
            Log.e(TAG, "Cancelled")
        }
    }

    // when press profile from navigation view
    override fun onNavigationItemSelected(menuItem: MenuItem): Boolean {
        when (menuItem.itemId) {
            R.id.profileFragment-> {
                startActivityForResult(Intent(this@MainActivity, AboutMeFragment::class.java), MY_PROFILE_REQUEST_CODE)
            }
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}