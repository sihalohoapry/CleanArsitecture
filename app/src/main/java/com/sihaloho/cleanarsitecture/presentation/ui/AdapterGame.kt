package com.sihaloho.cleanarsitecture.presentation.ui

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sihaloho.cleanarsitecture.databinding.ItemListGameBinding

class AdapterGame : RecyclerView.Adapter<AdapterGame.GameViewHolder>() {

    inner class GameViewHolder(view: View) : RecyclerView.ViewHolder(view){
        val binding = ItemListGameBinding.bind(view)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}