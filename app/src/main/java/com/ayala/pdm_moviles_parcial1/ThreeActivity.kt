package com.ayala.pdm_moviles_parcial1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.ayala.pdm_moviles_parcial1.fragments.NewGame
import kotlinx.android.synthetic.main.fragment_new_game.*


class ThreeActivity : AppCompatActivity(), NewGame.SearchNewMovieListener {
    override fun nextActivity() {
        var mIntent = Intent(this,  FourActivity:: class.java)
        mIntent.putExtra("key_local_3", frag_nuevo_local.getText().toString())
        mIntent.putExtra("key_visitante_3", frag_nuevo_visitante.getText().toString())
        mIntent.putExtra("key_fecha", frag_nuevo_fecha.getText().toString())
        mIntent.putExtra("key_hora", frag_nuevo_hora.getText().toString())
        //mIntent.putExtra("key_visitante", "lol")


        this.startActivity(mIntent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_three)


        val Detalles= NewGame()
        Detalles.arguments= intent.extras
        supportFragmentManager.beginTransaction().add(R.id.container2,Detalles).commit()

    }
}
