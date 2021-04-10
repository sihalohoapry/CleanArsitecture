package com.sihaloho.cleanarsitecture.presentation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
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
        binding.progressBar.visibility = View.VISIBLE
        homeViewModel.getListGame.observe(this, { data ->
            if (data != null) {
                when (data) {
                    is Resource.Loading -> binding.progressBar.visibility = View.VISIBLE
                    is Resource.Success -> {
                        binding.progressBar.visibility = View.GONE
                        adapterGame.setData(data.data)
                        adapterGame.notifyDataSetChanged()
                    }
                    is Resource.Error -> {
                        binding.progressBar.visibility = View.GONE
                        Toast.makeText(this, data.message, Toast.LENGTH_SHORT).show()

                    }
                }
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