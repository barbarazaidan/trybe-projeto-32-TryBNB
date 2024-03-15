package com.betrybe.trybnb.ui.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.betrybe.trybnb.R
import com.betrybe.trybnb.data.models.ReservationData
import com.betrybe.trybnb.ui.adapters.ReservationAdapter

class ReservationFragment : Fragment() {

    private lateinit var listReservation: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_reservation, container, false)
        listReservation = view.findViewById(R.id.reservation_recycler_view)

        //val reservationList = listOf(
          //  ReservationData("Barbara", "12-03-2024", "15-03-2024", "vinho", "299")
       // )

        listReservation.layoutManager = GridLayoutManager(context, 1)
        // listReservation.adapter = ReservationAdapter(reservationList)
        return view
    }
}