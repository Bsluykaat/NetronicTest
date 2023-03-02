package com.kerumitbsl.netronictest.ui.mainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.kerumitbsl.netronictest.R
import com.kerumitbsl.netronictest.databinding.ActivityMainBinding
import com.kerumitbsl.netronictest.other.SearchViewRetriever

class MainActivity : AppCompatActivity(), SearchViewRetriever {

    private val binder: ActivityMainBinding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val appBarConfiguration = AppBarConfiguration.Builder(setOf(R.id.nav_users)).build()
    private val navController: NavController by lazy { findNavController(R.id.nav_host_fragment_content_main) }

    private val onDestinationChangedListener =
        NavController.OnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.nav_users, R.id.nav_history -> binder.appBarSearchView.visibility = View.VISIBLE
                else -> binder.appBarSearchView.visibility = View.GONE
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binder.root)

        setSupportActionBar(binder.toolbar)

        setupActionBarWithNavController(navController, appBarConfiguration)

        navController.addOnDestinationChangedListener(onDestinationChangedListener)
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }

    override fun getAppBarSearchView(): SearchView = binder.appBarSearchView
}