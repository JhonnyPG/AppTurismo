package com.lemarin31.aventurateporcolombia

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class cityActivity : Fragment() {
    lateinit var binding: cityActivity


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmento = inflater.inflate(R.layout.activity_city, container, false)
        val detallefestividades: Button = fragmento.findViewById(R.id.buttonHist)
        detallefestividades.setOnClickListener(View.OnClickListener {

            activity?.supportFragmentManager?.beginTransaction()
                ?.setReorderingAllowed(true)
                ?.replace(R.id.cities, Activity_Festividades::class.java, null, "festividades")
                ?.addToBackStack("")
                ?.commit()


        })
        return fragmento
    }
}