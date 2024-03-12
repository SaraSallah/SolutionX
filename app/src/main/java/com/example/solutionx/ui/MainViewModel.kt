package com.example.solutionx.ui

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.solutionx.data.Repository
import com.example.solutionx.data.models.Entity.Country
import com.example.solutionx.data.models.Entity.Currency
import com.example.solutionx.data.models.Entity.Filter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel(), MainInteractionListener<AdapterModel> {

    private val _state = MutableStateFlow(MainUiState())
    val state = _state.asStateFlow()
    val repository = Repository()

    init {
        getAllCurrency(repository.getAllCurrency())
//        getAllCountry(repository.getAllCountry())
//        getAllFilter(repository.getAllFilter())

    }

    private fun getAllCurrency(currencyList: List<Currency>) {
        _state.update {
            it.copy(
                currency = currencyList.toCurrencyUiState() ,
                model = currencyList.toCurrencyUiState().toModelList()

            )
        }

    }

    private fun getAllCountry(countryList: List<Country>) {
        _state.update {
            it.copy(
                country = countryList.toCountryUiState(),
                model = countryList.toCountryUiState().toModelList()
            )
        }
    }

    private fun getAllFilter(filterList: List<Filter>) {
        _state.update {
            it.copy(
                filter = filterList.toFilterUiState(),
                model = filterList.toFilterUiState().toModelList()
            )
        }

    }

    override fun onClickItem(item: AdapterModel) {
        val updatedState = updateModel(_state.value.model, item.id)
        _state.update { it.copy(model = updatedState) }
        Log.e("Sara",_state.value.model.toString())
    }
    fun updateModel(list :List<Model>,selectedItemId:Int):List<Model>{
        return list.map { item ->
            item.copy(isSelected = item.id == selectedItemId)
        }

    }
}




