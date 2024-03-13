package com.example.solutionx.features.helper.domain.repository

import android.content.Context
import com.example.solutionx.features.helper.data.Entity.Country
import com.example.solutionx.features.helper.data.Entity.Currency
import com.example.solutionx.features.helper.data.Entity.Filter

interface LocalDs {
    fun getAllCountries(context: Context): List<Country>
    fun getAllCurrencies(context: Context): List<Currency>
    fun getAllFilters(context: Context): List<Filter>
}