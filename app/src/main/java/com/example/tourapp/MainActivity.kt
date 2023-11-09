package com.example.tourapp

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import data.TourPackage

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
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun getPackagesList(): List<TourPackage> {
        // Implementa la lógica para obtener la lista de paquetes turísticos
        val packagesList = repositories.PackageRepository.get()
        return packagesList
    }
}