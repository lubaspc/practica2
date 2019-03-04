package com.ittoluca.lubinpc.practica2.Activity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.design.widget.NavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import com.ittoluca.lubinpc.practica2.Eliminar
import com.ittoluca.lubinpc.practica2.Fragment.mcrear
import com.ittoluca.lubinpc.practica2.Fragment.mlistar
import com.ittoluca.lubinpc.practica2.Fragment.mmodificar
import com.ittoluca.lubinpc.practica2.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.app_bar_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        val toggle = ActionBarDrawerToggle(
            this, drawer_layout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawer_layout.addDrawerListener(toggle)
        toggle.syncState()

        nav_view.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (drawer_layout.isDrawerOpen(GravityCompat.START)) {
            drawer_layout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_settings -> return true
            else -> return super.onOptionsItemSelected(item)
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        var mifragmento: Fragment?=null
        when (item.itemId) {
            R.id.mCrear -> {
                mifragmento=mcrear()
            }
            R.id.mListar -> {
                mifragmento=mlistar()
            }
            R.id.mModificar -> {
                mifragmento=mmodificar()
            }
            R.id.mSalir -> {
                mifragmento=Eliminar()

            }
            R.id.nav_share -> {

            }
            R.id.nav_send -> {

            }

        }
        if(mifragmento!=null){
            supportFragmentManager.beginTransaction().replace(R.id.contenedorr, mifragmento!!).commit()
            supportActionBar!!.title=item.title
        }
        drawer_layout.closeDrawer(GravityCompat.START)
        return true
    }
}
