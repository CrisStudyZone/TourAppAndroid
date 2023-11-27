package com.example.tourapp.data

import com.example.tourapp.model.TransportType

data class TourPackage(
  val id: Long,
  val name: String,
  val transport: TransportType,
  val duration: Int,
  val stars: Double,
  val price: Double,
  val logo: String,
  val destination: Destination
)
