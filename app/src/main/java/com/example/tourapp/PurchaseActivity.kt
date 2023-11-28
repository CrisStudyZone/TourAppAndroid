package com.example.tourapp

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.tourapp.data.Purchase
import com.example.tourapp.data.TourPackage
import com.example.tourapp.data.User
import com.example.tourapp.exception.InsufficientMoneyException
import org.imaginativeworld.whynotimagecarousel.ImageCarousel
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import com.example.tourapp.repositories.PackageRepository
import com.example.tourapp.repositories.PurchaseRepository
import com.example.tourapp.repositories.UserRepository
import com.example.tourapp.resources.Carousel
import org.imaginativeworld.whynotimagecarousel.utils.setImage
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class PurchaseActivity : AppCompatActivity(){

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchase)

        val choisePackage = intent.getLongExtra("PackageID", -1)
        val userLoginId = intent.getLongExtra("userId", -1)
        val carouselItems: List<CarouselItem> = Carousel.runCarousel(choisePackage)

        val packageToBuy = PackageRepository.getById(choisePackage)
        val userLogin = UserRepository.findUserById(userLoginId)
        val finalPrice = packageToBuy!!.transport.appliesCommission(packageToBuy, packageToBuy.price)
        val stars = findViewById<RatingBar>(R.id.ratingBarPackageSelect)
        val carouselView: ImageCarousel = findViewById(R.id.imagePackageCarouselView)
        val buttonBuy = findViewById<Button>(R.id.buttonBuyPackageSelect)
        val textPackageName = findViewById<TextView>(R.id.textViewPackageSelect)
        val textPackageDuration = findViewById<TextView>(R.id.textViewDurationPackageSelect)
        val textPackageTransport = findViewById<TextView>(R.id.textViewTransportPackageSelect)
        val textFinalPrice = findViewById<TextView>(R.id.textViewPricePackageSelect)
        val textAvailableMoney = findViewById<TextView>(R.id.availableMoney)
        val transportImageView = findViewById<ImageView>(R.id.transport_image_view)

        textPackageName.text = packageToBuy.name
        textPackageDuration.text = "Lasts ${packageToBuy.duration}  days"
        textPackageTransport.text = packageToBuy.transport.toString()
        when(textPackageTransport.text) {
            "Bus" -> transportImageView.setImageResource(R.drawable.baseline_directions_bus_24)
            "Ferry" -> transportImageView.setImageResource(R.drawable.baseline_directions_boat_24)
            "AirPlane" -> transportImageView.setImageResource(R.drawable.baseline_airplanemode_active_24)
            "Train" -> transportImageView.setImageResource(R.drawable.baseline_train_24)
        }
        textFinalPrice.text = "Final price: \n$finalPrice"
        stars.rating = packageToBuy.stars.toFloat()
        carouselView.addData(carouselItems)
        if (userLogin != null) {
            textAvailableMoney.text = "Available money: \n${userLogin.money}"
        }
        buttonBuy.setOnClickListener {
            // Acción al hacer clic en el botón "Buy"
            if(userLogin != null){
                buyPackage(userLogin, packageToBuy)
            }
        }
    }

    fun processPurchase(user: User, finalPrice: Double) : Boolean {
        if (user.money >= finalPrice){
            user.money -= finalPrice
            return true
        }
        return false
    }

    @RequiresApi(Build.VERSION_CODES.O)
    fun instantiatePurchase(finalPrice: Double, user: User, packet: TourPackage): Purchase {
        val nextPurchaseId = PurchaseRepository.getNextPurchaseId()
        return Purchase(
            id = nextPurchaseId,
            userId = user.id,
            packageId = packet.id,
            amount = finalPrice,
            createdDate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm"))
        )
    }
    @RequiresApi(Build.VERSION_CODES.O)
    private fun buyPackage(user: User, packet: TourPackage) {
        val finalPrice = packet.transport.appliesCommission(packet, packet.price)
        val intent = Intent(this, MainActivity::class.java)
        try {
            if(processPurchase(user, finalPrice)){
                val purchase = instantiatePurchase(finalPrice, user, packet)
                PurchaseRepository.add(purchase)
                Toast.makeText(this, "Package Bought!!", Toast.LENGTH_LONG).show()
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            } else{
                throw InsufficientMoneyException()
            }
        }catch(e: InsufficientMoneyException){
            Toast.makeText(this, e.message, Toast.LENGTH_LONG).show()
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
            finish()
        }
    }
}

