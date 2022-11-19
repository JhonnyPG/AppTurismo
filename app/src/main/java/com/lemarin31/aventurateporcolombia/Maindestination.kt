package com.lemarin31.aventurateporcolombia

import android.app.Activity
import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.bumptech.glide.Glide
import com.google.android.material.navigation.NavigationView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.ktx.Firebase


import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference
import java.io.ByteArrayOutputStream
import java.io.File


class Maindestination : AppCompatActivity() {
    private lateinit var appBarConfiguration: AppBarConfiguration
    private var imgpath: Uri? = null

    private val pickImage = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destination)

        if (savedInstanceState==null){
            supportFragmentManager.beginTransaction()
                .setReorderingAllowed(true)
                .add(R.id.cities,citiesActivity::class.java,null,"nada")
                .commit()
        }

        setSupportActionBar(findViewById(R.id.my_barradestinos))


        val drawerLayout:DrawerLayout=findViewById(R.id.drawerlayout)
        val NavView:NavigationView=findViewById(R.id.nav_view)

        val navHostFragment=supportFragmentManager.findFragmentById(R.id.cities)as NavHostFragment
        val navController=navHostFragment.navController

        appBarConfiguration=AppBarConfiguration(setOf(R.id.nav_home,R.id.nav_cam,R.id.nav_contact,R.id.nav_help),drawerLayout)

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
        //username desde fire
        val intentobj : Intent = intent


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

                    var storageref = FirebaseStorage.getInstance().reference
                    val profileimg = findViewById<ImageView>(R.id.nav_image)

                    val uri = storageref.child("/perfil/$usuario.jpg")
                    val ONE_MEGABYTE = File.createTempFile(usuario,"jpg")
                    val imgstore = FirebaseStorage.getInstance().getReference("/perfil/$usuario.jpg")

                    imgstore.getFile(ONE_MEGABYTE).addOnSuccessListener {
                        Glide.with(this)
                            .load(ONE_MEGABYTE)
                            .into(profileimg)
                    }.addOnFailureListener{
                        Toast.makeText(this, "Sin datos", Toast.LENGTH_LONG).show()

                    }

                } else {
                    Toast.makeText(this, "Sin datos", Toast.LENGTH_LONG).show()
                }
            }
            .addOnFailureListener { exception ->
                Toast.makeText(this, "Message error: $exception", Toast.LENGTH_LONG).show()
            }


        /* profileimg.setOnClickListener{
             intent = Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI)
             intent.setType("image/*")
             startActivityForResult(intent, pickImage)


         }*/

         */

        //capturar imagen desde camara
        val profileimg = findViewById<ImageView>(R.id.nav_image)
        profileimg.setOnClickListener {
            startForResult.launch(Intent(MediaStore.ACTION_IMAGE_CAPTURE))
        }

    }
    private val startForResult = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){

            result : ActivityResult ->
        if(result.resultCode == RESULT_OK){
            val userid = FirebaseAuth.getInstance()


            val usuario =  userid.currentUser!!.email.toString()
            val imgstore = FirebaseStorage.getInstance().getReference("/perfil/$usuario.jpg")

            val intent = result.data


            val imagebitmap = intent?.extras?.get("data") as Bitmap
            val baos = ByteArrayOutputStream()
            imagebitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos)
            val datos = baos.toByteArray()
            val profileimg = findViewById<ImageView>(R.id.nav_image)
            profileimg.setImageBitmap(imagebitmap)
            imgstore.putBytes(datos)

        }

    }


    fun basedatos(btnlogin : View){
        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .add(R.id.cities,citiesActivity::class.java,null,"cities")
            .commit()

    }


}