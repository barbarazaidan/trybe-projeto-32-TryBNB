package com.betrybe.trybnb.ui.adapters

import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.betrybe.trybnb.R
import com.betrybe.trybnb.data.models.ReservationData
import com.google.android.material.textfield.TextInputLayout

class ReservationAdapter(private val reservationList: List<ReservationData>): Adapter<ReservationAdapter.ReservationViewHolder>() {

    class ReservationViewHolder(private val view: View) : ViewHolder(view) {
        var nomeHospede: TextInputLayout = view.findViewById(R.id.first_name_create_reservation)
        var dataCheckin: TextInputLayout = view.findViewById(R.id.checkin_create_reservation)
        var dataCheckout: TextInputLayout = view.findViewById(R.id.checkout_create_reservation)
        var info: TextInputLayout = view.findViewById(R.id.additional_needs_create_reservation)
        var price: TextInputLayout = view.findViewById(R.id.total_price_create_reservation)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReservationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_reservation, parent, false)
        return ReservationViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReservationViewHolder, position: Int) {
        holder.nomeHospede = reservationList[position].nomeHospede
        holder.dataCheckin = reservationList[position].dataCheckin
        holder.dataCheckout = reservationList[position].dataCheckout
        holder.info = reservationList[position].info
        holder.price = reservationList[position].price
    }

    override fun getItemCount(): Int = reservationList.size
}