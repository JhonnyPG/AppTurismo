package com.lemarin31.aventurateporcolombia

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class TemplateActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_template)
        if (savedInstanceState == null)
            supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.Fragmentcity, citiesActivity :: class.java, null,"todo" )
                .commit()
    }
}