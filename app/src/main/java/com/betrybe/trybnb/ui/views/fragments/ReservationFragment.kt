package com.betrybe.trybnb.ui.views.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.betrybe.trybnb.R
import com.betrybe.trybnb.common.ApiIdlingResource
import com.betrybe.trybnb.data.api.ApiService
import com.betrybe.trybnb.ui.adapters.ReservationAdapter
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class ReservationFragment : Fragment() {

    private lateinit var listReservation: RecyclerView
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_reservation, container, false)
        listReservation = view.findViewById(R.id.reservation_recycler_view)

      // val list = listOf()

        listReservation.layoutManager = GridLayoutManager(context, 1)
        // listReservation.adapter = ReservationAdapter(list)
        callApiService()
        return view
    }

    private fun callApiService() {

        CoroutineScope(Dispatchers.IO).launch {

            try {
                // ADICIONAR ESSA LINHA
                ApiIdlingResource.increment()

                val retrofit = Retrofit.Builder()
                    .baseUrl("https://restful-booker.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                val apiListIds = retrofit.create(ApiService::class.java)
                val responseApi = apiListIds.getBookingList()

                if (responseApi.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        Log.d("LoginResponse", responseApi.toString())
                        val reservationsIds = responseApi.body()!!
                        reservationsIds?.let {
                            //val adapter = ReservationAdapter(it)
                            // listReservation.adapter = adapter
                        }
                    }
                } else {
                    // Log.d("AuthenticationFailure", "Falha de autenticação: ${response.code()}")
                    MaterialAlertDialogBuilder(requireContext())
                        .setMessage("Erro ao carregar as reservas. Tente novamente mais tarde.")
                        .setPositiveButton("Ok") { dialog, _ -> dialog.dismiss() }
                        .setCancelable(false)
                        .create().show()
                }

                // ADICIONAR ESSA LINHA
                ApiIdlingResource.decrement()
            } catch (e: HttpException) {
                // ADICIONAR ESSA LINHA
                ApiIdlingResource.decrement()

                //...
                // Seu Codigo de erro de HttpException
                // ...
            } catch (e: IOException) {
                // ADICIONAR ESSA LINHA
                ApiIdlingResource.decrement()

                //...
                // Seu Codigo de erro de IOException
                // ...
            }
        }
    }
}