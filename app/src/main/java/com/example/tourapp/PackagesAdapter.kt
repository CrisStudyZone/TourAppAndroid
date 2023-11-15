package com.example.tourapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
//import com.squareup.picasso.Picasso
import data.TourPackage
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import resources.Carousel


class PackagesAdapter(
    private val context: Context,
    private val packages: List<TourPackage>)
    : RecyclerView.Adapter<PackagesAdapter.PackageViewHolder>() {
    inner class PackageViewHolder(itemView: View)
        : RecyclerView.ViewHolder(itemView) {
        val nameTextView: TextView = itemView.findViewById(R.id.textViewPackageName)
        val transportTextView: TextView = itemView.findViewById(R.id.textViewTransport)
        val durationTextView: TextView = itemView.findViewById(R.id.textViewDuration)
        val starsRatingBar: RatingBar = itemView.findViewById(R.id.ratingBar)
        val priceTextView: TextView = itemView.findViewById(R.id.textViewPrice)
        val buyButton: Button = itemView.findViewById(R.id.buttonBuy)
        val carouselView: ImageCarousel = itemView.findViewById(R.id.imagePackageCarouselView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PackageViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.item_package, parent, false)
        return PackageViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: PackageViewHolder, position: Int) {
        val currentPackage = packages[position]
        val carouselItems: List<CarouselItem> = Carousel.runCarousel(currentPackage.id)

        holder.nameTextView.text = currentPackage.name
        holder.transportTextView.text = currentPackage.transport.toString()
        holder.durationTextView.text = "Duration: ${currentPackage.duration} days"
        holder.starsRatingBar.rating = currentPackage.stars.toFloat()
        holder.priceTextView.text = "Price: $${currentPackage.price}"
        holder.carouselView.addData(carouselItems)

        val buyButtonLabel = context.getString(R.string.buy_button_label_template, position + 1)
        holder.buyButton.text = buyButtonLabel

        // Crea un Intent para iniciar LoginActivity
        val intent = Intent(context, LoginActivity::class.java).apply{
            //Envio el Package seleccionado
            putExtra("PackageID", currentPackage.id)
        }

        holder.buyButton.setOnClickListener {

            // Inicia PurchaseActivity utilizando el contexto proporcionado desde la actividad principal
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return packages.size
    }

}

