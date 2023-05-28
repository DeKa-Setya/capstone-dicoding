package com.example.myapplication.ui.Cart

import com.example.myapplication.PaymentSuccess
import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Cart.ListIkanAdapter
import com.example.myapplication.R
import com.example.myapplication.databinding.ActivityCartBinding
import com.example.myapplication.ui.Cart.Ikan

class CartActivity : AppCompatActivity() {
    private lateinit var rvIkan: RecyclerView
    private val list = ArrayList<Ikan>()
    private lateinit var binding: ActivityCartBinding

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCartBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.checkoutBtn.setOnClickListener {
            onButtonClick()
        }

        rvIkan = findViewById(R.id.rv_ikan)
        rvIkan.setHasFixedSize(true)

        list.addAll(getListIkan())
        showRecyclerList()
    }

    private fun getListIkan(): ArrayList<Ikan> {
        val dataPhoto = resources.obtainTypedArray(R.array.data_gambar)
        val dataIkan = resources.getStringArray(R.array.data_ikan)
        val dataHarga = resources.getStringArray(R.array.data_harga)
        val listIkan = ArrayList<Ikan>()
        for (i in dataIkan.indices) {
            val ikan = Ikan(dataPhoto.getResourceId(i,-1), dataIkan[i], dataHarga[i])
            listIkan.add(ikan)
        }
        return  listIkan
    }
    private fun showRecyclerList() {
        rvIkan.layoutManager = LinearLayoutManager(this)
        val listIkanAdapter = ListIkanAdapter(list)
        rvIkan.adapter = listIkanAdapter
    }

    private fun onButtonClick() {
        val intent = Intent(this, PaymentSuccess::class.java)
        startActivity(intent)
    }
}