package com.sihaloho.cleanarsitecture.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.sihaloho.cleanarsitecture.R
import com.sihaloho.cleanarsitecture.data.Resource
import com.sihaloho.cleanarsitecture.databinding.ActivityMainBinding
import org.koin.android.viewmodel.ext.android.viewModel

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val homeViewModel: HomeViewModel by viewModel()
    private var adapterGame = AdapterGame()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapterGame = AdapterGame()
        setAdapterGame()
        setData()

    }

    private fun setData() {
        homeViewModel.getListGame.observe(this, { data ->
            if (data != null) {
                adapterGame.setData(data)
                adapterGame.notifyDataSetChanged()
            }
        })
    }

    private fun setAdapterGame() {
        with(binding.rvListGame) {
            layoutManager = GridLayoutManager(this@HomeActivity, 3)
            setHasFixedSize(true)
            adapter = adapterGame
            adapterGame.onClick = {
                Toast.makeText(this@HomeActivity, it.name, Toast.LENGTH_SHORT).show()
            }
        }
    }
}