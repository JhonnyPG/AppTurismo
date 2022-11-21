package com.lemarin31.aventurateporcolombia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.lemarin31.aventurateporcolombia.databinding.ActivityDetallesCaliBinding
import com.lemarin31.aventurateporcolombia.databinding.ActivityDetallesCartagenaBinding
import java.io.File

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
        var storageimgn = FirebaseStorage.getInstance().getReference("/Ciudades/Cartagena/013B7D71-CD4A-496C-9F90-73F4F44F6475.jpeg")
        //creamos un archivo temporal
        val tempimg = File.createTempFile("Cartagena", "jpg")
        //llamamos el imageView
        val localimgn = binding.imgcartagena
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