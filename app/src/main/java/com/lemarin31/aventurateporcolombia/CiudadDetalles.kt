package com.lemarin31.aventurateporcolombia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import com.lemarin31.aventurateporcolombia.databinding.ActivityCiudadDetallesBinding

class CiudadDetalles : AppCompatActivity() {
    lateinit var binding:ActivityCiudadDetallesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ciudad_detalles)
        binding = ActivityCiudadDetallesBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db: FirebaseFirestore = FirebaseFirestore.getInstance()//obtine una instancia

        binding.imgciudad.setOnClickListener {
            var datos = ""
            db.collection("Ciudades")
                .get()//obtener todos los datos
                .addOnSuccessListener { resultado ->
                    for (documento in resultado) {
                        datos += "${documento.id}:${documento.data}\n"
                    }
                    binding.txtFestividades.text = datos
                }
                .addOnFailureListener { exception ->
                    binding.txtGatronomia.text = "no se ha podido conetar"
                }
        }
    }
}