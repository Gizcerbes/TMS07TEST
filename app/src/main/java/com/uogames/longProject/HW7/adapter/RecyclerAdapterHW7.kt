package com.uogames.longProject.HW7.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.uogames.longProject.HW7.MainViewModelHW7
import com.uogames.longProject.HW7.database.entity.Item
import com.uogames.longProject.R

class RecyclerAdapterHW7(private val viewModel: MainViewModelHW7) :
    RecyclerView.Adapter<RecyclerAdapterHW7.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(item: Item) {
            val imageItem = itemView.findViewById<ImageView>(R.id.hw7_image_view)
            val nameItem = itemView.findViewById<TextView>(R.id.hw7_name_item)
            val betItem = itemView.findViewById<TextView>(R.id.hw7_bet)
            val participant = itemView.findViewById<TextView>(R.id.hw7_participant)

            Picasso.get().load(item.image).into(imageItem)
            nameItem.text = item.name
            betItem.text = String.format("%0.2f parrots", item.currentPay)
            participant.text = item.currentParticipant

            itemView.setOnClickListener {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_recycler_item_hw7, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val let = viewModel.itemList.value?.get(position)?.let { it -> holder.setData(it) }
    }

    override fun getItemCount(): Int {
        return viewModel.itemList.value?.size ?: 0
    }


}