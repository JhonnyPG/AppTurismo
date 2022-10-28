package com.lemarin31.aventurateporcolombia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast


class Maindestination : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destination)
        setSupportActionBar(findViewById(R.id.my_barradestinos))

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_destinos,menu)
        return super.onCreateOptionsMenu(menu)
    }
    fun basedatos(btnlogin : View){
        Toast.makeText(applicationContext,getResources().getString(R.string.tex_baselogin),
            Toast.LENGTH_LONG)
            .show()
    }
}