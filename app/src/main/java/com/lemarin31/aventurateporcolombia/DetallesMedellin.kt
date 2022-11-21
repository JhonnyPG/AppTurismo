package com.lemarin31.aventurateporcolombia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.lemarin31.aventurateporcolombia.databinding.ActivityDetallesBogotaBinding
import com.lemarin31.aventurateporcolombia.databinding.ActivityDetallesMedellinBinding
import java.io.File

class DetallesMedellin : AppCompatActivity() {
    lateinit var binding: ActivityDetallesMedellinBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallesMedellinBinding.inflate(layoutInflater)
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
        var storageimgn = FirebaseStorage.getInstance().getReference("/Ciudades/Medellín/948D3CC3-551F-4904-9386-61A5BD4DB96D.webp")
        //creamos un archivo temporal
        val tempimg = File.createTempFile("Medellin", "webp")
        //llamamos el imageView
        val localimgn = binding.imgmedellin
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