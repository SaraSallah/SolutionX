package com.example.solutionx.features.helper

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.example.solutionx.R
import com.example.solutionx.databinding.ActivityMainBinding
import com.example.solutionx.features.helper.presentation.MainAdapter
import com.example.solutionx.features.helper.presentation.MainViewModel
import com.example.solutionx.utils.Logger
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewModel = viewModel

        val adapter = MainAdapter(mutableListOf(), viewModel)
        binding.rvModel.adapter = adapter

        lifecycleScope.launchWhenStarted {
            viewModel.state.collect { state ->
                adapter.setItems(state.currency)
                adapter.updateDate(state.model)
            }
        }

        Logger.log("This is a LogCat message")
        Log.e("",viewModel.state.value.currency.toString())


    }


}





