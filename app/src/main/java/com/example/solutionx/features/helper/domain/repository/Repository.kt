package com.example.solutionx.features.helper.domain.repository

import android.content.Context
import com.example.solutionx.features.helper.domain.model.Country
import com.example.solutionx.features.helper.domain.model.Currency
import com.example.solutionx.features.helper.domain.model.Filter

interface Repository {
    fun getAllCountries(context: Context): List<Country>
    fun getAllCurrencies(context: Context): List<Currency>
    fun getAllFilters(context: Context): List<Filter>
}