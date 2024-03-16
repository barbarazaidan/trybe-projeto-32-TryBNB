package com.betrybe.trybnb.ui.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.betrybe.trybnb.R
import com.betrybe.trybnb.common.ApiIdlingResource
import com.betrybe.trybnb.data.api.ApiService
import com.betrybe.trybnb.data.api.LoginRequest
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.material.textfield.TextInputLayout
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.IOException

class ProfileFragment : Fragment() {

    private lateinit var inputLogin: TextInputLayout
    private lateinit var inputPassword: TextInputLayout
    private lateinit var buttonLogin: Button
    private lateinit var successMessage: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        inputLogin = view.findViewById(R.id.login_input_profile)
        inputPassword = view.findViewById(R.id.password_input_profile)
        buttonLogin = view.findViewById(R.id.login_button_profile)
        successMessage = view.findViewById(R.id.success_message)

        buttonLogin.setOnClickListener {
            handleLogin()
        }

        return view
    }

    private fun callApiService(username: String, password: String) {

        CoroutineScope(Dispatchers.IO).launch {

            try {
                // ADICIONAR ESSA LINHA
                ApiIdlingResource.increment()

                val retrofit = Retrofit.Builder()
                    .baseUrl("https://restful-booker.herokuapp.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

                val apiLogin = retrofit.create(ApiService::class.java)
                val responseApi = apiLogin.postLoginAuthentication(LoginRequest(username, password))

                if (responseApi.isSuccessful) {
                    withContext(Dispatchers.Main) {
                        val loginResponse = responseApi.body()
                        // Log.d("LoginResponse", loginResponse.toString())
                        successMessage.visibility = View.VISIBLE
                    }
                } else {
                    // Log.d("AuthenticationFailure", "Falha de autenticação: ${response.code()}")
                    MaterialAlertDialogBuilder(requireContext())
                        .setMessage("Dados inválido. Tente de novo")
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

    private fun handleLogin() {
        val username = inputLogin.editText?.text.toString()
        val password = inputPassword.editText?.text.toString()

        isValidCredentials(username, password)
    }

    private fun isValidCredentials(username: String, password: String) {
        if (username.isEmpty()) {
            inputLogin.error = "O campo Login é obrigatório"
        } else {
            inputLogin.error = null
        }
        if (password.isEmpty()) {
            inputPassword.error = "O campo Password é obrigatório"
        } else {
            inputPassword.error = null
        }

        if (username.isNotEmpty() && password.isNotEmpty()) {
            callApiService(username, password)
        }
    }
}