package com.ayala.pdm_moviles_parcial1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ayala.pdm_moviles_parcial1.fragments.MainContentFragment
import kotlinx.android.synthetic.main.fragment_main_content.*


class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val fDetalles= MainContentFragment()
        fDetalles.arguments= intent.extras
        supportFragmentManager.beginTransaction().add(R.id.container,fDetalles).commit()





    }
}
