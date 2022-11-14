package com.lemarin31.aventurateporcolombia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun welcom(btncontinuar : View){
        val intent= Intent(this,welcomActivity::class.java).apply {  }
        startActivity(intent)
    }

    fun loginup(btnlogin :View){
        val intent=Intent(this,LoginActivity::class.java).apply{ }
        startActivity(intent)
    }
    fun prueba(btnprueba : View){
        val intent= Intent(this,CiudadDetalles::class.java).apply {  }
        startActivity(intent)
    }

    }