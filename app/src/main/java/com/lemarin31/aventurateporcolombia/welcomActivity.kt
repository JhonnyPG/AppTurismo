package com.lemarin31.aventurateporcolombia

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth



class welcomActivity : AppCompatActivity() {
    private var edtusername : EditText?=null
    private var edtpassword : EditText?=null

    lateinit var correo :EditText
    lateinit var contraseña :EditText





    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcom)
        setSupportActionBar(findViewById(R.id.my_barrainiciosesion))
        edtusername = findViewById(R.id.edtusername)
        edtpassword = findViewById(R.id.edtpassword)

        correo = findViewById(R.id.edtusername)
        contraseña = findViewById(R.id.edtpassword)

    }



    val Mensajeok ={ dialog: DialogInterface,which:Int->
        val intent= Intent(this,Maindestination::class.java).apply {  }
        startActivity(intent)
    }
    val Mensajecancel={_:DialogInterface,_:Int->}


    val logeo ={ dialog: DialogInterface, which:Int->
        val intent= Intent(this,Maindestination::class.java).apply {  }
        startActivity(intent)


    }


    fun alert1 (){
        val dialog = AlertDialog.Builder(this)
            .setTitle(resources.getString(R.string.welcome))
            .setMessage(null)
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

    fun destino (btndestino : View){

        var mail = correo!!.text.toString();
        var password = contraseña!!.text.toString();

        if(edtusername!!.text.isNotEmpty() && edtpassword!!.text.isNotEmpty() ){
            FirebaseAuth.getInstance().signInWithEmailAndPassword(mail,password).addOnCompleteListener {
                if(it.isSuccessful){
                    alert1()
                }else{
                    alert2()
                }
            }
        }else{
            alert2()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_registro,menu)
        return super.onCreateOptionsMenu(menu)
    }


    fun logeogoogle (logeogoogle :View){

    }


}