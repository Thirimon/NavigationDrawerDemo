package com.example.navigationdrawerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import android.widget.Toolbar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    private lateinit var drawer:DrawerLayout
    private lateinit var toggle:ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        drawer = findViewById(R.id.drawerLayout)
        val navigationView = findViewById<NavigationView>(R.id.navView)
       // val toolbar=findViewById<Toolbar>(R.id.toolbar)

        toggle = ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, HomeFragment()).commit()
            navigationView.setCheckedItem(R.id.nav_home)
        }
        navigationView.setNavigationItemSelectedListener {
            when(it.itemId){
                R.id.nav_home-> Toast.makeText(this,"Home Clicked",Toast.LENGTH_LONG).show()
                R.id.nav_msg-> Toast.makeText(this,"Message Clicked",Toast.LENGTH_LONG).show()
                R.id.nav_delete-> Toast.makeText(this,"Delete Clicked",Toast.LENGTH_LONG).show()
                R.id.nav_share-> Toast.makeText(this,"Share Clicked",Toast.LENGTH_LONG).show()
                R.id.nav_login-> Toast.makeText(this,"Login Clicked",Toast.LENGTH_LONG).show()
                R.id.nav_contact-> Toast.makeText(this,"Contact Clicked",Toast.LENGTH_LONG).show()
                R.id.nav_rateus-> Toast.makeText(this,"Home Clicked",Toast.LENGTH_LONG).show()
            }
            true
        }
       /* navigationView.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, HomeFragment()).commit()
                R.id.nav_msg -> supportFragmentManager.beginTransaction().replace(R.id.fragment_container, MessageFragment()).commit()
                R.id.nav_share->supportFragmentManager.beginTransaction().replace(R.id.fragment_container, ShareFragment()).commit()

            }
            drawer.closeDrawer(GravityCompat.START)
            true
        }*/
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item))
            return true
        else
            return super.onOptionsItemSelected(item)
    }
    override fun onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}