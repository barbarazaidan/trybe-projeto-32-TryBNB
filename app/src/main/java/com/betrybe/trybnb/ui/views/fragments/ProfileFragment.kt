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
    private lateinit var inpuPassword: TextInputLayout
    private lateinit var buttonLogin: Button
    // private lateinit var layout: LinearLayout
    // private lateinit var mscrollview: ScrollView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        // mscrollview = view.findViewById(R.id.profile_scroll_view)
        // layout = view.findViewById(R.id.profile_container)
        inputLogin = view.findViewById(R.id.login_input_profile)
        inpuPassword = view.findViewById(R.id.password_input_profile)
        buttonLogin = view.findViewById(R.id.login_button_profile)

        return view
    }
}