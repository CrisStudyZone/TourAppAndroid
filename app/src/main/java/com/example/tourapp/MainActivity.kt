package com.example.tourapp

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import data.TourPackage
import repositories.UserRepository

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val packagesAdapter = PackagesAdapter(this,getPackagesList())
        recyclerView.adapter = packagesAdapter
        Log.i("currentUser", UserRepository.currentUser?.name.toString())
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater: MenuInflater = menuInflater
        inflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when(item.itemId) {
            R.id.show_history_menu_item -> {
                showHistory()
                true
            }
            R.id.logout_menu_item -> {
                logout()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun logout() {
        if(UserRepository.currentUser!=null){
            Toast.makeText(this, getString(R.string.logged_out_toast), Toast.LENGTH_SHORT).show()
            UserRepository.currentUser = null
            finish()
            startActivity(intent)
        } else {
            Toast.makeText(this, getString(R.string.no_one_is_logged_in_toast), Toast.LENGTH_SHORT).show()
        }
    }

    private fun showHistory() {
        if(UserRepository.currentUser!=null){
            val intent = Intent()
            intent.setClass(this,HistoryActivity::class.java)
            startActivity(intent)
        } else {
            Toast.makeText(this, getString(R.string.no_one_is_logged_in_toast), Toast.LENGTH_SHORT).show()
        }
    }

    @RequiresApi(Build.VERSION_CODES.O)
    private fun getPackagesList(): List<TourPackage> {
        // Implementa la lógica para obtener la lista de paquetes turísticos
        val packagesList = repositories.PackageRepository.get()
        return packagesList
    }
}