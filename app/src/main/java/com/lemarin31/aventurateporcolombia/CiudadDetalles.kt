package com.lemarin31.aventurateporcolombia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import com.lemarin31.aventurateporcolombia.databinding.ActivityCiudadDetallesBinding

class CiudadDetalles : AppCompatActivity() {
    lateinit var binding:ActivityCiudadDetallesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityCiudadDetallesBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val db: FirebaseFirestore = FirebaseFirestore.getInstance()//obtine una instancia

        binding.detalles.setOnClickListener{
            val ciudad=binding.txtnombre.text.toString()
            db.collection("Bogota")
                .document(ciudad)
                .get()
                .addOnSuccessListener{
                    binding.txtFestividades.setText(it.get("Festividades") as String?)// IT ES EL DOCUMENTO POR DEFECTO
                    binding.txtGatronomia.setText(it.get("Gastronomia") as String?)
                    binding.txtHistoria.setText(it.get("Historia") as String?)
                }
        }

    }
}