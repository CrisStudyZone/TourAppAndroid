package com.example.tourapp

import android.os.Build
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import data.Purchase
import data.TourPackage
import data.User
import exception.InsufficientMoneyException
import repositories.PackageRepository
import repositories.PurchaseRepository
import repositories.UserRepository
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class PurchaseActivity : AppCompatActivity(){

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_purchase)

        val choisePackage = intent.getLongExtra("Package", -1)
        val userLoginId = intent.getLongExtra("User", -1)

        val packageToBuy = PackageRepository.getById(choisePackage)
        val userLogin = UserRepository.findUserById(userLoginId)

        val buttonBuy = findViewById<Button>(R.id.buttonBuyPackageSelect)
        val textPackage = findViewById<TextView>(R.id.textViewPackageSelect)
        val durationPackage = findViewById<TextView>(R.id.textViewDurationPackageSelect)

        buttonBuy.setOnClickListener {
            // Acción al hacer clic en el botón "Buy"
            if(userLogin != null && packageToBuy != null){
                buyPackage(userLogin, packageToBuy)
            }

        }


    }

    fun processPurchase(user: User, finalPrice: Double) : Boolean {
        if (user.money >= finalPrice){
            user.money -= finalPrice
            println("Purchase successful!")
            println("$: ${user?.money} left")
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
        try {
            if(processPurchase(user, finalPrice)){
                val purchase = instantiatePurchase(finalPrice, user, packet)
                PurchaseRepository.add(purchase)
            } else{
                throw InsufficientMoneyException()
            }
        }catch(e: InsufficientMoneyException){
            println(e.message)
        }
    }

}

