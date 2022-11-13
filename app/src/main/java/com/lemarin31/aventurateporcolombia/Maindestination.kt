package com.lemarin31.aventurateporcolombia

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase


class Maindestination : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destination)

        setSupportActionBar(findViewById(R.id.my_barradestinos))


        val drawerLayout:DrawerLayout=findViewById(R.id.drawerlayout)
        val NavView:NavigationView=findViewById(R.id.nav_view)

        val navHostFragment=supportFragmentManager.findFragmentById(R.id.cities)as NavHostFragment
        val navController=navHostFragment.navController

        appBarConfiguration=AppBarConfiguration(setOf(R.id.nav_cam,R.id.nav_contact,R.id.nav_help),drawerLayout)

        setupActionBarWithNavController(navController,appBarConfiguration)
        NavView.setupWithNavController(navController)






    }

    override fun onSupportNavigateUp(): Boolean {
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.cities)as NavHostFragment
        val navController=navHostFragment.navController

        return navController.navigateUp(appBarConfiguration)||super.onSupportNavigateUp()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_destinos,menu)
        usuario()
        return super.onCreateOptionsMenu(menu)
    }

    fun usuario (){
        val intentobj : Intent = intent
        var corre = intentobj.getStringExtra("correo").toString()

        val textv = findViewById<TextView>(R.id.nav_textview)



        val userid = FirebaseAuth.getInstance()
        val db = FirebaseFirestore.getInstance()

        val usuario =  userid.currentUser!!.email.toString()

        val docRef = db.collection("usuario").document(usuario)
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    val usert: String? = document.getString("Usuario")
                    textv.setText(usert)



                } else {
                    Toast.makeText(this, "Sin datos", Toast.LENGTH_LONG).show()
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Message error: $exception", Toast.LENGTH_LONG).show()
            }

    }


    fun basedatos(btnlogin : View){
        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .add(R.id.cities,citiesActivity::class.java,null,"cities")
            .commit()

    }
}