package com.example.solutionx.features.helper.domain.repository

import com.example.solutionx.features.helper.domain.model.Country
import com.example.solutionx.features.helper.domain.model.Currency
import com.example.solutionx.features.helper.domain.model.Filter

interface HelperRepository {
    fun getAllCountries(): List<Country>
    fun getAllCurrencies(): List<Currency>
    fun getAllFilters(): List<Filter>
}