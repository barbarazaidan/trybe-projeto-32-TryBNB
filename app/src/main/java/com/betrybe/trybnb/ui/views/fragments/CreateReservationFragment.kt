package com.betrybe.trybnb.ui.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.betrybe.trybnb.R
import com.google.android.material.textfield.TextInputLayout

class CreateReservationFragment : Fragment() {

    private lateinit var firstName: TextInputLayout
    private lateinit var lastName: TextInputLayout
    private lateinit var checkinDate: TextInputLayout
    private lateinit var checkoutDate: TextInputLayout
    private lateinit var additionalInfo: TextInputLayout
    private lateinit var totalPrice: TextInputLayout
    private lateinit var deposit: CheckBox
    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_create_reservation, container, false)
        firstName = view.findViewById(R.id.first_name_create_reservation)
        lastName = view.findViewById(R.id.last_name_create_reservation)
        checkinDate = view.findViewById(R.id.checkin_create_reservation)
        checkoutDate = view.findViewById(R.id.checkout_create_reservation)
        additionalInfo = view.findViewById(R.id.additional_needs_create_reservation)
        totalPrice = view.findViewById(R.id.total_price_create_reservation)
        deposit = view.findViewById(R.id.depositpaid_create_reservation)
        button = view.findViewById(R.id.create_reservation_button)

        return view
    }
}