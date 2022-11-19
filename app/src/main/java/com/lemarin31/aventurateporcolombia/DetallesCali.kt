package com.lemarin31.aventurateporcolombia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import com.lemarin31.aventurateporcolombia.databinding.ActivityDetallesBogotaBinding
import com.lemarin31.aventurateporcolombia.databinding.ActivityDetallesCaliBinding

class DetallesCali : AppCompatActivity() {
    lateinit var binding: ActivityDetallesCaliBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallesCaliBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val db: FirebaseFirestore = FirebaseFirestore.getInstance()//obtine una instancia


        binding.btnFestividades.setOnClickListener {
            val docuid = binding.txtNumero.text.toString()
            db.collection("Ciudades")
                .document(docuid)
                .get()
                .addOnSuccessListener {
                    binding.txtDetalles.setText(it.get("Festividades") as String?)// IT ES EL DOCUMENTO POR DEFECTO

                }
            binding.btnGatronomia.setOnClickListener {
                val docuid = binding.txtNumero.text.toString()
                db.collection("Ciudades")
                    .document(docuid)
                    .get()
                    .addOnSuccessListener {
                        binding.txtDetalles.setText(it.get("Gastronomia") as String?)// IT ES EL DOCUMENTO POR DEFECTO

                    }
                binding.btnHistoria.setOnClickListener {
                    val docuid = binding.txtNumero.text.toString()
                    db.collection("Ciudades")
                        .document(docuid)
                        .get()
                        .addOnSuccessListener {
                            binding.txtDetalles.setText(it.get("Historia") as String?)// IT ES EL DOCUMENTO POR DEFECTO

                        }
                }
            }
        }
    }
}