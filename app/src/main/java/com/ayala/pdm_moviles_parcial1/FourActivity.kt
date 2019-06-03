package com.ayala.pdm_moviles_parcial1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProviders
import com.ayala.pdm_moviles_parcial1.Entity.Game
import com.ayala.pdm_moviles_parcial1.ViewModel.GameViewModel
import com.ayala.pdm_moviles_parcial1.fragments.ControlGame
import com.ayala.pdm_moviles_parcial1.fragments.NewGame
import kotlinx.android.synthetic.main.fragment_control_game.*
import kotlinx.android.synthetic.main.fragment_new_game.*

class FourActivity : AppCompatActivity(), ControlGame.interfacegame {


    override fun aumentar1_local() {
        val numero1 = marcador_local.getText().toString()
        val aux=numero1.toInt()
        marcador_local.text=((aux+1)).toString()

    }

    override fun aumentar2_local() {
        val numero1 = marcador_local.getText().toString()
        val aux=numero1.toInt()
        marcador_local.text=((aux+2)).toString()

    }

    override fun aumentar3_local() {
        val numero1 = marcador_local.getText().toString()
        val aux=numero1.toInt()
        marcador_local.text=((aux+3)).toString()

    }

    override fun aumentar1_visitante() {
        val numero1 = marcador_visitante.getText().toString()
        val aux=numero1.toInt()
        marcador_visitante.text=((aux+1)).toString()

    }

    override fun aumentar2_visitante() {
        val numero1 = marcador_visitante.getText().toString()
        val aux=numero1.toInt()
        marcador_visitante.text=((aux+2)).toString()

    }

    override fun aumentar3_visitante() {
        val numero1 = marcador_visitante.getText().toString()
        val aux=numero1.toInt()
        marcador_visitante.text=((aux+3)).toString()

    }

    override fun nextActivity() {
        val viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)
        val local=control_local.getText().toString()
        val visitante=control_visitante.getText().toString()
        viewModel.insert(Game(local.toString(), visitante.toString(), marcador_local.getText().toString(),marcador_visitante.getText().toString(), control_fecha.getText().toString(), control_hora.getText().toString()))
        var mIntent = Intent(this,  MainActivity:: class.java)

        this.startActivity(mIntent)
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_four)



        val fDetalles= ControlGame()
        fDetalles.arguments= intent.extras
        supportFragmentManager.beginTransaction().add(R.id.container3,fDetalles).commit()


    }
}
