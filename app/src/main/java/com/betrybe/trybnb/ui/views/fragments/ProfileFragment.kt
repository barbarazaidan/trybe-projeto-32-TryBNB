package com.betrybe.trybnb.ui.views.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.ScrollView
import androidx.fragment.app.Fragment
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.betrybe.trybnb.R
import com.google.android.material.textfield.TextInputLayout
import java.util.regex.Pattern.matches

class ProfileFragment : Fragment() {

    private lateinit var inputLogin: TextInputLayout
    private lateinit var inputPassword: TextInputLayout
    private lateinit var buttonLogin: Button

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        inputLogin = view.findViewById(R.id.login_input_profile)
        inputPassword = view.findViewById(R.id.password_input_profile)
        buttonLogin = view.findViewById(R.id.login_button_profile)

        buttonLogin.setOnClickListener {
            handleLogin()
        }

        return view
    }

    private fun handleLogin() {
        val username = inputLogin.editText?.text.toString()
        val password = inputPassword.editText?.text.toString()

       isBlankCredentials(username, password)
    }

    private fun isBlankCredentials(username: String, password: String) {
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
    }

//    private fun isValidCredentials(username: String, password: String): Boolean {
//        // Lógica para verificar se os campos não estão vazios
//        return username.isNotEmpty() && password.isNotEmpty()
//    }
}