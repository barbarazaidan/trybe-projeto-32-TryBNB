package com.betrybe.trybnb.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.betrybe.trybnb.R
import com.betrybe.trybnb.data.models.ReservationInfoApi

class ReservationAdapter(private val reservationList: List<ReservationInfoApi>): Adapter<ReservationAdapter.ReservationViewHolder>() {

    class ReservationViewHolder(private val view: View) : ViewHolder(view) {
        var nomeHospede: TextView = view.findViewById(R.id.name_item_reservation)
        var dataCheckin: TextView = view.findViewById(R.id.checkin_item_reservation)
        var dataCheckout: TextView = view.findViewById(R.id.checkout_item_reservation)
        var info: TextView = view.findViewById(R.id.additional_needs_item_reservation)
        var price: TextView = view.findViewById(R.id.total_price_item_reservation)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReservationViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_reservation, parent, false)
        return ReservationViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReservationViewHolder, position: Int) {
        val firstName: String = reservationList[position].firstName
        val lastName: String = reservationList[position].lastName
        holder.nomeHospede.text = firstName + lastName
        holder.dataCheckin.text = reservationList[position].bookingDates.checkin
        holder.dataCheckout.text = reservationList[position].bookingDates.checkout
        holder.info.text = reservationList[position].additionalNeeds
        holder.price.text = reservationList[position].totalPrice.toString()
    }

    override fun getItemCount(): Int = reservationList.size
}