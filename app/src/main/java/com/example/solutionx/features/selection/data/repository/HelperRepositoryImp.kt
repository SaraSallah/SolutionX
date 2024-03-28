package com.example.solutionx.features.selection.data.repository

import com.example.solutionx.features.selection.data.mapper.toCountry
import com.example.solutionx.features.selection.data.mapper.toCurrency
import com.example.solutionx.features.selection.data.mapper.toFilter
import com.example.solutionx.features.selection.domain.model.Country
import com.example.solutionx.features.selection.domain.model.Currency
import com.example.solutionx.features.selection.domain.model.Filter
import com.example.solutionx.features.selection.domain.repository.HelperRepository
import javax.inject.Inject

class HelperRepositoryImp @Inject constructor(
    private val localDS: HelperLocalDSImp,
) : HelperRepository {
    override fun getAllCountries(): List<Country> =
        localDS.getAllCountries().map { it.toCountry() }

    override fun getAllCurrencies(): List<Currency> =
        localDS.getAllCurrencies().map { it.toCurrency() }

    override fun getAllFilters(): List<Filter> =
        localDS.getAllFilters().map { it.toFilter() }


}
