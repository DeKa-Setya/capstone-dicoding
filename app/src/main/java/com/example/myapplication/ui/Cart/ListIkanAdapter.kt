package com.example.myapplication.Cart

import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R
import com.example.myapplication.ui.Cart.Ikan

class ListIkanAdapter(private val listIkan: ArrayList<Ikan>): RecyclerView.Adapter<ListIkanAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_cart, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listIkan.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (photo, ikan, harga) = listIkan[position]
        holder.imgPhoto.setImageResource(photo)
        holder.tvName.text = ikan
        holder.tvDescription.text = harga
    }

    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgPhoto: ImageView = itemView.findViewById(R.id.img_photo)
        val  tvName: TextView = itemView.findViewById(R.id.tv_name)
        val tvDescription: TextView = itemView.findViewById(R.id.tv_description)
    }
}


