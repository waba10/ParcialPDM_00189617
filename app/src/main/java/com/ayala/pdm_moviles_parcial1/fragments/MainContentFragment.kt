package com.ayala.pdm_moviles_parcial1.fragments


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.ayala.pdm_moviles_parcial1.R


class MainContentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view= inflater.inflate(R.layout.fragment_main_content, container, false).apply {
            var equipo1= arguments?.getString("key_total_local")
            var equipo2= arguments?.getString("key_total_visitante")

            if(equipo1!!.toInt()> equipo2!!.toInt()){
                findViewById<TextView>(R.id.frag_ganador).text = arguments?.getString("key_local")
            }
            if(equipo1!!.toInt()== equipo2!!.toInt()){
                findViewById<TextView>(R.id.frag_ganador).text = "Empate"
            }
            if(equipo1!!.toInt()< equipo2!!.toInt()){
                findViewById<TextView>(R.id.frag_ganador).text = arguments?.getString("key_visitante")
            }



            findViewById<TextView>(R.id.frag_local).text = arguments?.getString("key_local")
            findViewById<TextView>(R.id.frag_visitante).text = arguments?.getString("key_visitante")
            findViewById<TextView>(R.id.frag_total_local).text = arguments?.getString("key_total_local")
            findViewById<TextView>(R.id.frag_total_visitante).text = arguments?.getString("key_total_visitante")
            findViewById<TextView>(R.id.frag_hora).text = arguments?.getString("key_hora")
            findViewById<TextView>(R.id.frag_fecha).text = arguments?.getString("key_fecha")
        }

        return view
    }


}
