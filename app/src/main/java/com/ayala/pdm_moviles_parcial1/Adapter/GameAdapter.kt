package com.ayala.pdm_moviles_parcial1.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ayala.pdm_moviles_parcial1.Entity.Game
import com.ayala.pdm_moviles_parcial1.R
import com.ayala.pdm_moviles_parcial1.SecondActivity
import kotlinx.android.synthetic.main.cardview_resultados.view.*
import kotlinx.android.synthetic.main.fragment_main_content.view.*

class GameAdapter internal constructor(context: Context) :  RecyclerView.Adapter<GameAdapter.BookViewHolder>
    () {

    private var games = emptyList<Game>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameAdapter.BookViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.cardview_resultados, parent, false)
        return BookViewHolder(itemView)
    }

    override fun getItemCount() = games.size

    override fun onBindViewHolder(holder: GameAdapter.BookViewHolder, position: Int) {
        holder.bind(games[position])
    }

    internal fun setBooks(lista: List<Game>) {
        this.games = lista
        notifyDataSetChanged()
    }

    class BookViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(game: Game) {
            with(itemView) {

                team_local.text=game.local
                team_visitant.text=game.visitante
                puntos_local.text=game.total_local
                puntos_visitante.text=game.total_visitante


                this.setOnClickListener {
                    var mIntent = Intent(it.context,  SecondActivity:: class.java)
                    mIntent.putExtra("key_local", game.local)
                    mIntent.putExtra("key_visitante", game.visitante)
                    mIntent.putExtra("key_total_local", game.total_local)
                    mIntent.putExtra("key_total_visitante", game.total_visitante)
                    mIntent.putExtra("key_hora", game.total_visitante)
                    mIntent.putExtra("key_fecha", game.total_visitante)
                    this.context.startActivity(mIntent)
                }

            }

        }
    }
}