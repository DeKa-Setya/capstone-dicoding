package com.example.myapplication.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.Product
import com.example.myapplication.ProductAdapter
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private lateinit var rvProductAgri: RecyclerView
    private lateinit var rvProductFish: RecyclerView
    private lateinit var rvProductUmkm: RecyclerView

    private val list = ArrayList<Product>()

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
//        val homeViewModel =
//            ViewModelProvider(this).get(HomeViewModel::class.java)

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

//        val textView: TextView = binding.textHome
//        homeViewModel.text.observe(viewLifecycleOwner) {
//            textView.text = it
//        }

        rvProductAgri = binding.rvProductAgri
        rvProductFish = binding.rvProductFish
        rvProductUmkm = binding.rvProductUmkm
        rvProductAgri.setHasFixedSize(true)
        rvProductFish.setHasFixedSize(true)
        rvProductUmkm.setHasFixedSize(true)

        list.addAll(getListHeroes())
        showRecyclerList()

        return root
    }

    private fun getListHeroes(): ArrayList<Product> {
        val dataName = resources.getStringArray(R.array.data_name)
        val dataPrice = resources.getStringArray(R.array.data_price)
        val dataPhoto = resources.obtainTypedArray(R.array.data_photo)
        val listHero = ArrayList<Product>()
        for (i in dataName.indices) {
            val hero = Product( dataPhoto.getResourceId(i, -1), dataName[i], dataPrice[i])
            listHero.add(hero)
        }
        return listHero
    }

    private fun showRecyclerList() {
        rvProductAgri.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rvProductFish.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        rvProductUmkm.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
        val listHeroAdapter = ProductAdapter(list)
        rvProductAgri.adapter = listHeroAdapter
        rvProductFish.adapter = listHeroAdapter
        rvProductUmkm.adapter = listHeroAdapter

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}