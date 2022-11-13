package com.lemarin31.aventurateporcolombia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class cityActivity : Fragment() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmento = inflater.inflate(R.layout.activity_cities, container, false)
        val detallebog: Button = fragmento.findViewById(R.id.btnBog)
        val detallemedellin: Button = fragmento.findViewById(R.id.buttonMed)
        val detallecali: Button = fragmento.findViewById(R.id.buttonCali)
        val detallecartagena: Button = fragmento.findViewById(R.id.buttonCarta)

        detallebog.setOnClickListener(View.OnClickListener {

            activity?.supportFragmentManager?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.cities, Activity_Festividades::class.java, null, "festividades")
                ?.addToBackStack("")
                ?.commit()


        })
        detallemedellin.setOnClickListener(View.OnClickListener {

            activity?.supportFragmentManager?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.cities, Activity_Festividades::class.java, null, "festividades")
                ?.addToBackStack("")
                ?.commit()


        })
        detallecali.setOnClickListener(View.OnClickListener {

            activity?.supportFragmentManager?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.cities, Activity_Festividades::class.java, null, "festividades")
                ?.addToBackStack("")
                ?.commit()


        })
        detallecartagena.setOnClickListener(View.OnClickListener {

            activity?.supportFragmentManager?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.cities, Activity_Festividades::class.java, null, "festividades")
                ?.addToBackStack("")
                ?.commit()


        })
        return fragmento
    }
}