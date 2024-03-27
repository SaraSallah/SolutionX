package com.example.solutionx.features.helper

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.example.solutionx.R
import com.example.solutionx.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
//    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_host) as NavHostFragment
//        binding.viewModel = viewModel

//        val adapter = MainAdapter(mutableListOf(), viewModel)
//        binding.rvModel.adapter = adapter
//
//        lifecycleScope.launchWhenStarted {
//            viewModel.state.collect { state ->
//                adapter.setItems(state.currency)
//                adapter.updateDate(state.model)
//            }
//        }
//
//        Logger.log("This is a LogCat message")
//        Log.e("",viewModel.state.value.currency.toString())


    }


}





