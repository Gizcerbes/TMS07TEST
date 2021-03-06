package com.uogames.longProject.HW7.adapter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.uogames.longProject.HW7.DatabaseViewModelHW7
import com.uogames.longProject.HW7.MainViewModelHW7
import com.uogames.longProject.HW7.database.entity.Item
import com.uogames.longProject.R

class RecyclerAdapterHW7(private val databaseModel: DatabaseViewModelHW7, private val viewModel: MainViewModelHW7) :
    RecyclerView.Adapter<RecyclerAdapterHW7.ItemViewHolder>() {


    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun setData(item: Item) {
            val imageItem = itemView.findViewById<ImageView>(R.id.hw7_image_view)
            val nameItem = itemView.findViewById<TextView>(R.id.hw7_name_item)
            val betItem = itemView.findViewById<TextView>(R.id.hw7_bet)
            val participant = itemView.findViewById<TextView>(R.id.hw7_participant)

            Picasso.get().load(item.image).into(imageItem)
            nameItem.text = item.name
            betItem.text = String.format("%.2f parrots", item.getCurrentPay())
            participant.text = item.currentParticipant
            itemView.setOnClickListener {
                val bundle = Bundle()
                bundle.putInt(MainViewModelHW7.ITEM_ID, item.id ?: 0)
                it.findNavController().navigate(R.id.show_fragmentShowItemHW7, bundle)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.fragment_recycler_item_hw7, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        databaseModel.itemList.value?.get(position)?.let { it -> holder.setData(it) }
    }

    override fun getItemCount(): Int {
        return databaseModel.itemList.value?.size ?: 0
    }


}