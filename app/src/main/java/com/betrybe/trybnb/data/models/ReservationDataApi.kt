package com.betrybe.trybnb.data.models

import com.betrybe.trybnb.data.api.BookingData
import com.google.gson.annotations.SerializedName

data class ReservationApiIds(
    @SerializedName("bookingid")
    val id: Int
)


data class ReservationInfoApi(
    @SerializedName("firstname")
    val firstName: String,
    @SerializedName("lastname")
    val lastName: String,
    @SerializedName("totalprice")
    val totalPrice: Int,
    @SerializedName("bookingdates")
    val bookingDates: BookingData,
    @SerializedName("additionalneeds")
    val additionalNeeds: String,
)