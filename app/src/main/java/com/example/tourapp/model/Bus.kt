package com.example.tourapp.model

import com.example.tourapp.data.TourPackage

class Bus : TransportType() {
    private val commission = 1.02
    override fun appliesCommission(
      packageToBuy: TourPackage?,
      pricePackage: Double
    ): Double {
        if(packageToBuy!=null){
            return pricePackage.times(commission)
        }
        return pricePackage
    }
    override fun toString(): String {
        return "Bus"
    }
}