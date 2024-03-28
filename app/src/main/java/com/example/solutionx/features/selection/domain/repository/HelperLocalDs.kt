package com.example.solutionx.features.selection.domain.repository

import com.example.solutionx.features.selection.data.Entity.Country
import com.example.solutionx.features.selection.data.Entity.Currency
import com.example.solutionx.features.selection.data.Entity.Filter

interface HelperLocalDs {
    fun getAllCountries(): List<Country>
    fun getAllCurrencies(): List<Currency>
    fun getAllFilters(): List<Filter>
}