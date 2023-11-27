package com.example.tourapp.model

import com.example.tourapp.data.TourPackage

open class TransportType {
    open fun appliesCommission(packageToBuy: TourPackage?, pricePackage: Double): Double{
        return pricePackage
    }
    //Aqui debe ser override porque todas las clases heredan de Any y toString() es un metodo de Any
    override fun toString(): String {
        return "TransportType"
    }
}