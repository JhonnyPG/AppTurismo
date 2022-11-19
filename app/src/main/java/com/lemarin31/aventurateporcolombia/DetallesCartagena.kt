package com.lemarin31.aventurateporcolombia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.firestore.FirebaseFirestore
import com.lemarin31.aventurateporcolombia.databinding.ActivityDetallesCaliBinding
import com.lemarin31.aventurateporcolombia.databinding.ActivityDetallesCartagenaBinding

class DetallesCartagena : AppCompatActivity() {
    lateinit var binding: ActivityDetallesCartagenaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallesCartagenaBinding.inflate(layoutInflater)
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