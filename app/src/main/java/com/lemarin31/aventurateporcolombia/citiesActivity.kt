package com.lemarin31.aventurateporcolombia

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class citiesActivity : Fragment () {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmento = inflater.inflate(R.layout.activity_cities, container, false)
        val detallebog: Button = fragmento.findViewById(R.id.btnBog)
        val detallemedellin: Button = fragmento.findViewById(R.id.buttonMed)
        val detallecali: Button = fragmento.findViewById(R.id.buttonCali)
        val detallecartagena: Button = fragmento.findViewById(R.id.buttonCarta)

        detallebog.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, DetallesBogota::class.java)
            startActivity(intent)
        })
        detallemedellin.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, DetallesMedellin::class.java)
            startActivity(intent)
        })
        detallecali.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, DetallesCali::class.java)
            startActivity(intent)
        })

        detallecartagena.setOnClickListener(View.OnClickListener {
            val intent = Intent(activity, DetallesCartagena::class.java)
            startActivity(intent)
        })




        return fragmento
    }

}


