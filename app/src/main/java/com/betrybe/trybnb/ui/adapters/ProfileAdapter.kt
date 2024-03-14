package com.betrybe.trybnb.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.betrybe.trybnb.R
import com.google.android.material.textfield.TextInputLayout

class ProfileAdapter : Adapter<ProfileAdapter.ProfileViewHolder>() {

    class ProfileViewHolder(private val view: View) : ViewHolder(view) {
        val login: TextInputLayout = view.findViewById(R.id.login_input_profile)
        val password: TextInputLayout = view.findViewById(R.id.password_input_profile)
        val buttonLogin: Button = view.findViewById(R.id.login_button_profile)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProfileViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_profile, parent, false)
        return ProfileViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProfileViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }
}