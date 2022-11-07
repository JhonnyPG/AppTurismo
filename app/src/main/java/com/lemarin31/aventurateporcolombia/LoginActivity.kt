package com.lemarin31.aventurateporcolombia

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

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
    lateinit var nombre :EditText
    lateinit var ususario :EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        nombre = findViewById(R.id.editTextnombre)
        ususario = findViewById(R.id.editTextusuario)
        correo = findViewById(R.id.editTextcorreo)
        contraseña = findViewById(R.id.editcontraseña1)
        contra = findViewById(R.id.editcontraseña2)



      //  val analitica = FirebaseAnalytics.getInstance(this)
      //  val paquete = Bundle()
      //  paquete.putString("messaje","integracion completa ")
      //  analitica.logEvent("Initcreen",paquete)

    }
    val logeo ={ dialog: DialogInterface, which:Int->
        val intent= Intent(this,Maindestination::class.java).apply {  }
        startActivity(intent)}
    val Mensajecancel={_:DialogInterface,_:Int->}


     fun guardar(btnguardar: View) {

// -------------autenticacion ok--------------------------------------
         FirebaseAuth.getInstance().createUserWithEmailAndPassword(
            correo.text.toString(),contraseña.text.toString())
//-----------------------------------------------------------------------

// ---------- guardar en base de datos---- no ok ---------------------
         FirebaseFirestore.getInstance().collection("Usuario").document(correo.text.toString())
             .set(hashMapOf("correo" to correo.text.toString(), "contraseña" to contraseña.text.toString(),
                     "Nombre" to nombre.text.toString(), "Usuario" to ususario.text.toString()))
//-----------------------------------------------------------------------------

         val dialog = AlertDialog.Builder(this)
             .setTitle(resources.getString(R.string.welcome))
             .setMessage(nombre!!.text.toString())
             .setPositiveButton("Ok", logeo)
             .create()
             .show()

     }


}

