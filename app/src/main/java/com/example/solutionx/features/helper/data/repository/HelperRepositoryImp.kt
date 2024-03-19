package com.example.solutionx.features.helper.data.repository

import com.example.solutionx.features.helper.data.mapper.toCountry
import com.example.solutionx.features.helper.data.mapper.toCurrency
import com.example.solutionx.features.helper.data.mapper.toFilter
import com.example.solutionx.features.helper.domain.model.Country
import com.example.solutionx.features.helper.domain.model.Currency
import com.example.solutionx.features.helper.domain.model.Filter
import com.example.solutionx.features.helper.domain.repository.HelperRepository
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
