package com.sihaloho.cleanarsitecture.presentation.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.sihaloho.cleanarsitecture.R
import com.sihaloho.cleanarsitecture.databinding.ItemListGameBinding
import com.sihaloho.cleanarsitecture.domain.entity.Game

class AdapterGame : RecyclerView.Adapter<AdapterGame.GameViewHolder>() {

    private var list = ArrayList<Game>()
    var onClick: ((Game) -> Unit)? = null

    fun setData(newList: List<Game>?) {
        if (newList == null) return
        list.clear()
        list.addAll(newList)
        notifyDataSetChanged()
    }

    inner class GameViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding = ItemListGameBinding.bind(view)
        fun bind(data: Game) {
            with(binding) {

                tvTitleGame.text = data.name
                tvDateGame.text = data.released
                tvRatingGame.text = data.rating.toString()

                Glide.with(itemView)
                    .load(data.backgroundImage)
                    .apply(
                        RequestOptions.placeholderOf(R.drawable.ic_loading_image)
                            .error(R.drawable.ic_image_fail)
                    )

                    .into(ivImageGame)
            }
        }
        init {
            binding.root.setOnClickListener {
                onClick?.invoke(list[adapterPosition])
            }
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder =
        GameViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_list_game, parent, false)
        )

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int = list.size

}