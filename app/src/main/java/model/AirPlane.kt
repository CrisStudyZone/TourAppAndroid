package model

import android.os.Build
import androidx.annotation.RequiresApi
import data.TourPackage
import java.time.LocalTime
import java.time.format.DateTimeFormatter

class AirPlane (private val hourToBuy: LocalTime) : TransportType() {
    @RequiresApi(Build.VERSION_CODES.O)
    private val initialDate = LocalTime.parse("15:00", DateTimeFormatter.ofPattern("HH:mm"))
    @RequiresApi(Build.VERSION_CODES.O)
    private val finalDate = LocalTime.parse("22:00", DateTimeFormatter.ofPattern("HH:mm"))
    private val commissionOnSchedule = 1.01
    private val commissionOffHours= 1.03
    @RequiresApi(Build.VERSION_CODES.O)
    override fun appliesCommission(
        packageToBuy: TourPackage?,
        pricePackage: Double
    ): Double {
        val finalPrice: Double
        if (packageToBuy != null && hourToBuy in initialDate..finalDate) {
            finalPrice = pricePackage.times(commissionOnSchedule)
        } else{
            finalPrice = pricePackage.times(commissionOffHours)
        }
        return finalPrice
    }

    override fun toString(): String {
        return "AirPlane"
    }
}