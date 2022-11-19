package com.lemarin31.aventurateporcolombia

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.google.firebase.firestore.FirebaseFirestore
import com.lemarin31.aventurateporcolombia.databinding.ActivityDetallesBogotaBinding


class Activity_Festividades : Fragment() {
    lateinit var binding: ActivityDetallesBogotaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetallesBogotaBinding.inflate(layoutInflater)

        val db: FirebaseFirestore = FirebaseFirestore.getInstance()//obtine una instancia

        binding.btnFestividades.setOnClickListener{
            val docuid=1
            db.collection("Ciudades")
                .document(docuid.toString())
                .get()
                .addOnSuccessListener {
                    binding.txtDetalles.setText(it.get("Festividades") as String?)// IT ES EL DOCUMENTO POR DEFECTO
                }
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmento = inflater.inflate(R.layout.fragment_activity__festividades, container, false)

        return fragmento

    }
}
