package com.betrybe.trybnb.data.models

import android.text.format.DateFormat
import com.google.android.material.textfield.TextInputLayout

class ReservationData(
    val nomeHospede: TextInputLayout,
    val dataCheckin: TextInputLayout,
    val dataCheckout: TextInputLayout,
    val info: TextInputLayout,
    val price: TextInputLayout
)
