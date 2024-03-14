package com.betrybe.trybnb.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.betrybe.trybnb.R
import com.betrybe.trybnb.data.models.ProfileData
import com.google.android.material.textfield.TextInputLayout

class ReservationAdapter(): Adapter<ReservationAdapter.ReservationViewHolder>() {

    class ReservationViewHolder(private val view: View) : ViewHolder(view) {
        // val login: TextInputLayout = view.findViewById(R.id.login_input_profile)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReservationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_reservation, parent, false)
        return ReservationViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReservationViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}