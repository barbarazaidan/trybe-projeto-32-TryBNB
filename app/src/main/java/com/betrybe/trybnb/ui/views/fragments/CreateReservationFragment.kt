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

    private lateinit var inputFirstName: TextInputLayout
    private lateinit var inputLastName: TextInputLayout
    private lateinit var inputCheckinDate: TextInputLayout
    private lateinit var inputCheckoutDate: TextInputLayout
    private lateinit var inputAdditionalInfo: TextInputLayout
    private lateinit var inputTotalPrice: TextInputLayout
    private lateinit var inputDeposit: CheckBox
    private lateinit var button: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_create_reservation, container, false)
        inputFirstName = view.findViewById(R.id.first_name_create_reservation)
        inputLastName = view.findViewById(R.id.last_name_create_reservation)
        inputCheckinDate = view.findViewById(R.id.checkin_create_reservation)
        inputCheckoutDate = view.findViewById(R.id.checkout_create_reservation)
        inputAdditionalInfo = view.findViewById(R.id.additional_needs_create_reservation)
        inputTotalPrice = view.findViewById(R.id.total_price_create_reservation)
        button = view.findViewById(R.id.create_reservation_button)

        button.setOnClickListener {
            handleLogin()
        }

        return view
    }

    private fun handleLogin() {
        val firstName = inputFirstName.editText?.text.toString()
        val lastName = inputLastName.editText?.text.toString()
        val checkin = inputCheckinDate.editText?.text.toString()
        val checkout = inputCheckoutDate.editText?.text.toString()
        val additionalInfo = inputAdditionalInfo.editText?.text.toString()
        val totalPrice = inputTotalPrice.editText?.text.toString()

        isValidCredentials(firstName, lastName, checkin, checkout, additionalInfo, totalPrice)
    }

    private fun isValidCredentials(
        firstName: String,
        lastName: String,
        checkin: String,
        checkout: String,
        additionalInfo: String,
        totalPrice: String
    ) {
        if (firstName.isEmpty()) {
            inputFirstName.error = "O campo Nome é obrigatório"
        } else {
            inputFirstName.error = null
        }
        if (lastName.isEmpty()) {
            inputLastName.error = "O campo Sobrenome é obrigatório"
        } else {
            inputLastName.error = null
        }

        if (checkin.isEmpty()) {
            inputCheckinDate.error = "O campo Checkin é obrigatório"
        } else {
            inputCheckinDate.error = null
        }

        if (checkout.isEmpty()) {
            inputCheckoutDate.error = "O campo Checkout é obrigatório"
        } else {
            inputCheckoutDate.error = null
        }

        if (additionalInfo.isEmpty()) {
            inputAdditionalInfo.error = "O campo Necessidades Adicionais é obrigatório"
        } else {
            inputAdditionalInfo.error = null
        }

        if (totalPrice.isEmpty()) {
            inputTotalPrice.error = "O campo Preço Total é obrigatório"
        } else {
            inputTotalPrice.error = null
        }
    }
}