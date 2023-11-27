package com.example.tourapp.model

import android.os.Build
import androidx.annotation.RequiresApi
import com.example.tourapp.data.TourPackage
import java.time.DayOfWeek
import java.time.LocalDate

class Train (private val dayToBuy: LocalDate) : TransportType() {
    private val weekendCommission = 1.03
    private val commissionWeekly = 1.0075
    @RequiresApi(Build.VERSION_CODES.O)
    override fun appliesCommission(
      packageToBuy: TourPackage?,
      pricePackage: Double
    ): Double {
        /*Inicializo la variable y cambio su condicion de val a var*/
        var finalPrice: Double = 0.0
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            when(dayToBuy.dayOfWeek){
                DayOfWeek.SATURDAY,
                DayOfWeek.SUNDAY -> finalPrice = pricePackage.times(weekendCommission)
                else -> finalPrice = pricePackage.times(commissionWeekly)
            }
        }
        return finalPrice
    }
    override fun toString(): String {
        return "Train"
    }
}