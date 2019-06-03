package com.ayala.pdm_moviles_parcial1

import android.content.Intent
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity;
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.ayala.pdm_moviles_parcial1.Adapter.GameAdapter
import com.ayala.pdm_moviles_parcial1.ViewModel.GameViewModel

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            /*Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()*/

            var mIntent = Intent(this,  ThreeActivity:: class.java)


            this.startActivity(mIntent)
        }

        val recyclerView = findViewById<RecyclerView>(R.id.rv_book_list)
        val adapter = GameAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)


        val viewModel = ViewModelProviders.of(this).get(GameViewModel::class.java)

        viewModel.getAll().observe(this, Observer { books ->
            books?.let { adapter.setBooks(it) }
        })

        viewModel.getAll().observe(this, Observer { books ->
            for (books in books) {
                //Log.d("Lista de libros", books.titleEnglish + books.titleSpanish + books.editorial)
            }
        })


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
