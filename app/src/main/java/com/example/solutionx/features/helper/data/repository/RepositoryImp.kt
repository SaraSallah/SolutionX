package com.example.solutionx.features.helper.data.repository

import android.content.Context
import com.example.solutionx.features.helper.data.mapper.toCountry
import com.example.solutionx.features.helper.data.mapper.toCurrency
import com.example.solutionx.features.helper.data.mapper.toFilter
import com.example.solutionx.features.helper.domain.model.Country
import com.example.solutionx.features.helper.domain.model.Currency
import com.example.solutionx.features.helper.domain.model.Filter
import com.example.solutionx.features.helper.domain.repository.Repository
import javax.inject.Inject

class RepositoryImp @Inject constructor(
    private val localDS: LocalDSImp,
) : Repository {
    override fun getAllCountries(context: Context): List<Country> =
        localDS.getAllCountries(context).map { it.toCountry() }

    override fun getAllCurrencies(context: Context): List<Currency> =
        localDS.getAllCurrencies(context).map { it.toCurrency() }

    override fun getAllFilters(context: Context): List<Filter> =
        localDS.getAllFilters(context).map { it.toFilter() }


}
