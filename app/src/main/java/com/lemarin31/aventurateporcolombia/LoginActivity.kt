package com.lemarin31.aventurateporcolombia

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class LoginActivity : AppCompatActivity() {
    lateinit var correo :EditText
    lateinit var contraseña :EditText
    lateinit var contra :EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        correo = findViewById(R.id.editTextcorreo)
        contraseña = findViewById(R.id.editcontraseña1)
        contra = findViewById(R.id.editcontraseña2)


      //  val analitica = FirebaseAnalytics.getInstance(this)
      //  val paquete = Bundle()
      //  paquete.putString("messaje","integracion completa ")
      //  analitica.logEvent("Initcreen",paquete)

    }

     fun guardar(btnguardar: View) {

         val dbfireabse = FirebaseFirestore.getInstance()

             dbfireabse.collection("Usuario").
             document().set(hashMapOf("correo" to correo.text.toString(),
                 "contraseña" to contraseña.text.toString()))
         Toast.makeText(applicationContext,"usuario registrado ", Toast.LENGTH_LONG).show()
             finish()

     }

}

