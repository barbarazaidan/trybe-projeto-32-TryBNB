package com.betrybe.trybnb.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.betrybe.trybnb.R
import com.betrybe.trybnb.data.models.ReservationApiIds

class ReservationIdAdapter(private val reservationIds: List<ReservationApiIds>) :
    RecyclerView.Adapter<ReservationIdAdapter.ReservationIdViewHolder>() {


    class ReservationIdViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        // private val idTextView: TextView = itemView.findViewById(R.id.idTextView)
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReservationIdViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_reservation, parent, false)
        return ReservationIdViewHolder(view)
    }

    override fun getItemCount(): Int = reservationIds.size

    override fun onBindViewHolder(holder: ReservationIdViewHolder, position: Int) {
        val reservationId = reservationIds[position]
        // holder.bind(reservationId)
    }
}
