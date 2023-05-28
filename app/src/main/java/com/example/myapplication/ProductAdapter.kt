package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ProductAdapter(private val listProduct: ArrayList<Product>) : RecyclerView.Adapter<ProductAdapter.ListViewHolder>() {
    class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imgProduct: ImageView = itemView.findViewById(R.id.img_item_photo)
        val tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        val tvPrice: TextView = itemView.findViewById(R.id.tv_item_price)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.product_card, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int = listProduct.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (photo, name, price) = listProduct[position]
        holder.imgProduct.setImageResource(photo)
        holder.tvName.text = name
        holder.tvPrice.text = price
    }

}