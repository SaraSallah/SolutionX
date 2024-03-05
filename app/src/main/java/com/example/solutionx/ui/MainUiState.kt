package com.example.solutionx.ui

import com.example.solutionx.data.model.Country
import com.example.solutionx.data.model.Currency
import com.example.solutionx.data.model.Filter


data class MainUiState(
    val currency: List<CurrencyUiState> = emptyList(),
    val country: List<CountryUiState> = emptyList(),
    val filter: List<FilterUiState> = emptyList(),
)

data class CountryUiState(
    override val id: Int = 0,
    override val name: String = " ",
    val currency: String = " ",
    val code: String = " ",
    val phone_code: String = " ",
    val flag: String = " ",
    override val isSelected: Boolean,
) : AdapterModel

data class CurrencyUiState(
    override val id: Int = 0,
    override val name: String = " ",
    val sign: String = "",
    val code: String = "",
    override val isSelected: Boolean,
) : AdapterModel

data class FilterUiState(
    override val id: Int = 0,
    override val name: String = "",
    override val isSelected: Boolean,
) : AdapterModel

interface AdapterModel {
    val id: Int
    val name: String
    val isSelected: Boolean
}

fun List<Filter>.toFilterUiState(): List<FilterUiState> {
    return map {
        FilterUiState(
            id = it.id,
            name = it.name,
            isSelected = false,

            )
    }
}

fun List<Country>.toCountryUiState(): List<CountryUiState> {
    return map {
        CountryUiState(
            id = it.id,
            name = it.name,
            currency = it.currency,
            code = it.code,
            phone_code = it.phone_code,
            flag = it.flag,
            isSelected = false,
        )
    }
}

fun List<Currency>.toCurrencyUiState(): List<CurrencyUiState> {
    return map {
        CurrencyUiState(
            id = it.id,
            name = it.name,
            code = it.code,
            isSelected = false,
        )
    }
}
