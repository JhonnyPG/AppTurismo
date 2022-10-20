package com.lemarin31.aventurateporcolombia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog

class welcomActivity : AppCompatActivity() {
    private var edtusername : EditText?=null
    private var edtpassword : EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcom)
        edtusername = findViewById(R.id.edtusername)
        edtpassword = findViewById(R.id.edtpassword)
    }
    fun destino(btndestino : View){
            if (edtusername!!.text.toString()=="admin" && edtpassword!!.text.toString()=="12345"){
                val intent= Intent(this,Maindestination::class.java).apply {  }
                startActivity(intent)}
        else{
            val botondialogo = AlertDialog.Builder(this).setTitle("Usuario o contraseña invalidos").setMessage("Ingrese usuario y o contraseña correcta").create().show()
        }
    }

}