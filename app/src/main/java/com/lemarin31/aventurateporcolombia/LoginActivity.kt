package com.lemarin31.aventurateporcolombia

import android.app.Activity
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.activity.result.contract.ActivityResultContracts.*
import androidx.appcompat.app.AlertDialog
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions

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

    fun alert1 (){
        val dialog = AlertDialog.Builder(this)
            .setTitle(resources.getString(R.string.welcome))
            .setMessage(nombre!!.text.toString())
            .setPositiveButton("Ok", logeo)
            .create()
            .show()
    }
    fun alert2(){
        val dialog = AlertDialog.Builder(this)
            .setTitle(resources.getString(R.string.Erroruser))
            .setMessage(null)
            .setPositiveButton("Ok", null)
            .create()
            .show()
    }
    fun alert3(){
        val dialog = AlertDialog.Builder(this)
            .setTitle("ERROR")
            .setMessage(resources.getString(R.string.text_passworderror))
            .setPositiveButton("Ok", null)
            .create()
            .show()
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////



    //////////////////////////////////////////////////////////////////////////////////////////////

    fun guardar ( btnguardar : View){
        var mail = correo!!.text.toString();
        var password = contraseña!!.text.toString();
        var password2 = contra!!.text.toString();
        var name = nombre!!.text.toString();
        var user = ususario!!.text.toString();
        if(password==password2){
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(mail,password).addOnCompleteListener {
            if(it.isSuccessful){
                FirebaseFirestore.getInstance().collection("usuario").document(mail).set(
                    hashMapOf("nombre" to name, "Usuario" to user, "correo" to mail, "contraseña" to password))
                alert1()
            }else{
                alert2()
            }
            }
        }else{
            alert3()
        }
    }

    fun logeogoogle (logeoguardar: View){

            /* val googleconfi = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                 .requestIdToken(getString(R.string.default_web_client_id)).requestEmail()
                 .build()
             val googlecliente = GoogleSignIn.getClient(this,googleconfi)

             val google = registerForActivityResult(StartActivityForResult()){ ActivityResult ->
                 googlecliente.signInIntent

             }*/
    }


}

