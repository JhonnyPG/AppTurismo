package com.lemarin31.aventurateporcolombia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Thread.sleep(4000)
        splashScreen.setKeepOnScreenCondition { false }



    }
    fun welcom(btncontinuar : View){
        val intent= Intent(this,welcomActivity::class.java).apply {  }
        startActivity(intent)
    }

    fun loginup(btnlogin :View){
        val intent=Intent(this,LoginActivity::class.java).apply{ }
        startActivity(intent)
    }


    
    }