package com.example.solutionx.features.helper.domain.repository

import com.example.solutionx.features.helper.data.Entity.Country
import com.example.solutionx.features.helper.data.Entity.Currency
import com.example.solutionx.features.helper.data.Entity.Filter

interface HelperLocalDs {
    fun getAllCountries(): List<Country>
    fun getAllCurrencies(): List<Currency>
    fun getAllFilters(): List<Filter>
}