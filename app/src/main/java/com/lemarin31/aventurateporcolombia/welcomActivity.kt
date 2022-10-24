package com.lemarin31.aventurateporcolombia

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AlertDialogLayout

class welcomActivity : AppCompatActivity() {
    private var edtusername : EditText?=null
    private var edtpassword : EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcom)
        edtusername = findViewById(R.id.edtusername)
        edtpassword = findViewById(R.id.edtpassword)
    }

    val Mensajeok ={ dialog: DialogInterface,which:Int->
        val intent= Intent(this,Maindestination::class.java).apply {  }
        startActivity(intent)
    }
    val Mensajecancel={_:DialogInterface,_:Int->}


    fun destino(btndestino : View){
            if (edtusername!!.text.toString()=="admin" && edtpassword!!.text.toString()=="12345") {
                //val intent= Intent(this,Maindestination::class.java).apply {  }
                //startActivity(intent)}
                val dialog = AlertDialog.Builder(this)
                    .setTitle(resources.getString(R.string.welcome))
                    .setMessage(edtusername!!.text.toString())
                    .setPositiveButton("Ok", Mensajeok)
                    .create()
                    .show()
            }
             else{
                 val botondialogo = AlertDialog.Builder(this)
                     .setTitle(resources.getString(R.string.Erroruser))
                     .setMessage(resources.getString(R.string.Errormenssage))
                     .setNegativeButton("OK",Mensajecancel)
                     .create()
                     .show()
                }

    }
}