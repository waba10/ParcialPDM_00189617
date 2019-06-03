package com.ayala.pdm_moviles_parcial1.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView

import com.ayala.pdm_moviles_parcial1.R
import kotlinx.android.synthetic.main.fragment_new_game.view.*


class NewGame : Fragment() {

    var listenerTool :  SearchNewMovieListener? = null

    interface SearchNewMovieListener{

        fun nextActivity()



    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view= inflater.inflate(R.layout.fragment_new_game, container, false).apply {


        }
        initSearchButton(view)

        return view

    }

    fun initSearchButton(container:View) = container.playgame.setOnClickListener {
        listenerTool?.nextActivity()
    }
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is SearchNewMovieListener) {
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
