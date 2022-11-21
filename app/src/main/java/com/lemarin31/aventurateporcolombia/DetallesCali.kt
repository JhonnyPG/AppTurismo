package com.lemarin31.aventurateporcolombia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.lemarin31.aventurateporcolombia.databinding.ActivityDetallesCaliBinding
import java.io.File

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
        }
            binding.btnGatronomia.setOnClickListener {
                val docuid = binding.txtNumero.text.toString()
                db.collection("Ciudades")
                    .document(docuid)
                    .get()
                    .addOnSuccessListener {
                        binding.txtDetalles.setText(it.get("Gastronomia") as String?)// IT ES EL DOCUMENTO POR DEFECTO

                    }
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

        // referencia al storage
        var storageimgn = FirebaseStorage.getInstance().getReference("/Ciudades/Cali/D2D0A7AF-B505-422F-B260-71B6619AE3BE.jpeg")
        //creamos un archivo temporal
        val tempimg = File.createTempFile("Cali", "jpg")
        //llamamos el imageView
        val localimgn = binding.imgcali
        // enviamos el archivo de storage  a el arhivo temporal creado
        storageimgn.getFile(tempimg).addOnSuccessListener {
            // Cargamos el archivo temporal a el ImageView usando Glide.
            Glide.with(this)
                .load(tempimg)
                .into(localimgn)
        }.addOnFailureListener {
            Toast.makeText(this, "Sin datos", Toast.LENGTH_LONG).show()

        }

    }
}