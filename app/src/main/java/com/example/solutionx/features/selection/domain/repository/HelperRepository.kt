package com.example.solutionx.features.selection.domain.repository

import com.example.solutionx.features.selection.domain.model.Country
import com.example.solutionx.features.selection.domain.model.Currency
import com.example.solutionx.features.selection.domain.model.Filter

interface HelperRepository {
    fun getAllCountries(): List<Country>
    fun getAllCurrencies(): List<Currency>
    fun getAllFilters(): List<Filter>
}