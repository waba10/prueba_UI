package com.ayala.uii.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.ayala.uii.R


class detalles : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_detalles, container, false).apply {
            findViewById<TextView>(R.id.tv_fragment_name).text = arguments?.getString("key_nombre")
            findViewById<TextView>(R.id.tv_fragment_id).text = arguments?.getString("key_ambito")
        }

        return view
    }


}
