package com.ayala.pdm_moviles_parcial1.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import com.ayala.pdm_moviles_parcial1.R
import kotlinx.android.synthetic.main.fragment_control_game.view.*
import kotlinx.android.synthetic.main.fragment_new_game.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class ControlGame : Fragment() {
    var listenerTool :  interfacegame? = null

    interface interfacegame{

        fun nextActivity()
        fun aumentar1_local()
        fun aumentar2_local()
        fun aumentar3_local()
        fun aumentar1_visitante()
        fun aumentar2_visitante()
        fun aumentar3_visitante()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view= inflater.inflate(R.layout.fragment_control_game, container, false).apply {

            findViewById<TextView>(R.id.control_local).text = arguments?.getString("key_local_3")
            findViewById<TextView>(R.id.control_visitante).text = arguments?.getString("key_visitante_3")

            findViewById<TextView>(R.id.control_fecha).text = arguments?.getString("key_fecha")

            findViewById<TextView>(R.id.control_hora).text = arguments?.getString("key_hora")

        }
        initSearchButton(view)
        initlocal1(view)
        initlocal2(view)
        initlocal3(view)
        initvisitante1(view)
        initvisitante2(view)
        initvisitante3(view)



        return view
    }

    fun initSearchButton(container:View) = container.end.setOnClickListener {
        listenerTool?.nextActivity()
    }
    fun initlocal1(container:View) = container.mas1_local.setOnClickListener {
        listenerTool?.aumentar1_local()
    }
    fun initlocal2(container:View) = container.mas2_local.setOnClickListener {
        listenerTool?.aumentar2_local()
    }
    fun initlocal3(container:View) = container.mas3_local.setOnClickListener {
        listenerTool?.aumentar3_local()
    }
    fun initvisitante1(container:View) = container.mas1_visitante.setOnClickListener {
        listenerTool?.aumentar1_visitante()
    }
    fun initvisitante2(container:View) = container.mas2_visitante.setOnClickListener {
        listenerTool?.aumentar2_visitante()
    }
    fun initvisitante3(container:View) = container.mas3_visitante.setOnClickListener {
        listenerTool?.aumentar3_visitante()
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is ControlGame.interfacegame) {
            listenerTool = context
        } else {
            throw RuntimeException("Se necesita una implementación de  la interfaz")
        }
    }
    override fun onDetach() {
        super.onDetach()
        listenerTool = null
    }


}
