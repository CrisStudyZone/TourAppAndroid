package com.example.tourapp

import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import data.Purchase
import repositories.PackageRepository

class HistoryAdapter(
    private val context: Context,
    private val packages: List<Purchase>
) : RecyclerView.Adapter<HistoryAdapter.HistoryViewHolder>() {
    inner class HistoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val packageNameTextView: TextView = itemView.findViewById(R.id.package_name_card_text_view)
        val dateTextView: TextView = itemView.findViewById(R.id.date_card_text_view)
        val amountTextView: TextView = itemView.findViewById(R.id.amount_card_text_view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_purchase, parent, false)
        return HistoryViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return packages.size
    }

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        val currentPurchase = packages[position]
        holder.packageNameTextView.text = PackageRepository.getById(currentPurchase.packageId)!!.name
        holder.dateTextView.text = currentPurchase.createdDate
        holder.amountTextView.text = context.getString(R.string.amount, currentPurchase.amount.toString())
    }
}