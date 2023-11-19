package com.example.tourapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import repositories.PurchaseRepository
import repositories.UserRepository

class HistoryActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val purchases = PurchaseRepository.get(UserRepository.currentUser!!.id)
        if(purchases.isEmpty()) {
            setContentView(R.layout.empty_history)
        } else {
            setContentView(R.layout.activity_history)
            val recyclerView: RecyclerView = findViewById(R.id.histoy_recycler_view)
            recyclerView.layoutManager = LinearLayoutManager(this)
            val adapter = HistoryAdapter(this, purchases)
            recyclerView.adapter = adapter
        }
    }
}