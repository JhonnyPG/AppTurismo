package com.lemarin31.aventurateporcolombia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class citiesActivity : Fragment () {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmento = inflater.inflate(R.layout.activity_cities,container,false)
        val detallesbog: Button =fragmento.findViewById(R.id.buttonBog)
        detallesbog.setOnClickListener(View.OnClickListener {

            activity?.supportFragmentManager?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.cities,cityActivity::class.java,null,"city")
                ?.addToBackStack("")
                ?.commit()
        })

        return fragmento
    }
}
