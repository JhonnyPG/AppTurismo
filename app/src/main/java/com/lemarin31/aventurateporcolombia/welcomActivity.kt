package com.lemarin31.aventurateporcolombia

import android.content.DialogInterface
import android.content.Intent
import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.AlertDialogLayout

class welcomActivity : AppCompatActivity() {
    private var edtusername : EditText?=null
    private var edtpassword : EditText?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcom)
        setSupportActionBar(findViewById(R.id.my_barrainiciosesion))


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
                Toast.makeText(applicationContext,getResources().getString(R.string.welcome),
                    Toast.LENGTH_LONG)
                    .show()
            }
             else{
                 val botondialogo = AlertDialog.Builder(this)
                     .setTitle(resources.getString(R.string.Erroruser))
                     .setMessage(resources.getString(R.string.Errormenssage))
                     .setNegativeButton(getResources().getString(R.string.Errormenssage),Mensajecancel)
                     .create()
                     .show()
                }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_registro,menu)
        return super.onCreateOptionsMenu(menu)
    }
}