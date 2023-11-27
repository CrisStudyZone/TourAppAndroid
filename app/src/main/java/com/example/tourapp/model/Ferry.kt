package com.example.tourapp.model

import com.example.tourapp.data.TourPackage

class Ferry  : TransportType() {
    override fun appliesCommission(
      packageToBuy: TourPackage?,
      pricePackage: Double
    ): Double {
        return pricePackage
    }
    override fun toString(): String {
        return "Ferry"
    }
}