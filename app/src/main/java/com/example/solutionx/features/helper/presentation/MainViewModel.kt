package com.example.solutionx.features.helper.presentation

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.solutionx.features.helper.MainActivity
import com.example.solutionx.features.helper.data.repository.RepositoryImp
import com.example.solutionx.features.helper.domain.model.Country
import com.example.solutionx.features.helper.domain.model.Currency
import com.example.solutionx.features.helper.domain.model.Filter
import com.example.solutionx.features.helper.domain.repository.Repository
import com.example.solutionx.features.helper.domain.usecase.GetAllCountriesUseCase
import com.example.solutionx.features.helper.domain.usecase.GetAllCurrenciesUseCase
import com.example.solutionx.features.helper.domain.usecase.GetAllFiltersUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ActivityContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject
@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllCountriesUseCase: GetAllCountriesUseCase ,
    private val getAllCurrenciesUseCase: GetAllCurrenciesUseCase ,
    private val getAllFiltersUseCase: GetAllFiltersUseCase
): ViewModel(), MainInteractionListener<AdapterModel> {

    private val _state = MutableStateFlow(MainUiState())
    val state = _state.asStateFlow()
    private val _context = MutableStateFlow<Context?>(null)
    val context =_context.asStateFlow()
    init {
        getAllCurrency(getAllCurrenciesUseCase.invoke(context.value!!.applicationContext))
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
    fun updateModel(list :List<Model>, selectedItemId:Int):List<Model>{
        return list.map { item ->
            item.copy(isSelected = item.id == selectedItemId)
        }

    }
}




