package com.ayala.uii

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ayala.uii.fragments.detalles

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val fDetalles= detalles()
        fDetalles.arguments= intent.extras
        supportFragmentManager.beginTransaction().add(R.id.container,fDetalles).commit()
    }
}
