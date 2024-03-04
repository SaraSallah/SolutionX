package com.example.solutionx

import androidx.lifecycle.ViewModel
import com.example.solutionx.data.Repository
import com.example.solutionx.data.model.Country
import com.example.solutionx.data.model.Currency
import com.example.solutionx.data.model.Filter
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class MainViewModel : ViewModel(), MainInteractionListener<AdapterModel> {

    private val _state = MutableStateFlow(MainUiState())
    val state = _state.asStateFlow()
    val repository = Repository()

    init {
        getAllCurrency(repository.getAllCurrency())
        getAllCountry(repository.getAllCountry())
        getAllFilter(repository.getAllFilter())

    }

    private fun getAllCurrency(currencyList: List<Currency>) {
        _state.update {
            it.copy(
                currency = currencyList.toCurrencyUiState()
            )
        }

    }

    private fun getAllCountry(countryList: List<Country>) {
        _state.update {
            it.copy(
                country = countryList.toCountryUiState()
            )
        }
    }

    private fun getAllFilter(filterList: List<Filter>) {
        _state.update {
            it.copy(
                filter = filterList.toFilterUiState()
            )
        }

    }

    override fun onClickItem(item: AdapterModel) {
        val updatedState = updateSelectedItem(_state.value, item.id)
        _state.value = updatedState
    }

    private fun updateSelectedItem(
        mainList: MainUiState,
        selectedCurrencyId: Int,
    ): MainUiState {
        val currency = mainList.currency.map { currency ->
            currency.copy(isSelected = currency.id == selectedCurrencyId)
        }

        val country = mainList.country.map { country ->
            country.copy(isSelected = country.id == selectedCurrencyId)
        }
        val filter = mainList.filter.map { filter ->
            filter.copy(isSelected = filter.id == selectedCurrencyId)
        }

        return MainUiState(currency, country, filter)
    }
}




