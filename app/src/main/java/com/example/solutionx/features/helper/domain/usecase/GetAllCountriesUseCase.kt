package com.example.solutionx.features.helper.domain.usecase

import android.content.Context
import com.example.solutionx.features.helper.domain.model.Country
import com.example.solutionx.features.helper.domain.repository.HelperRepository
import javax.inject.Inject

class GetAllCountriesUseCase @Inject constructor(
    private val repository: HelperRepository,
) {
    operator fun invoke(): List<Country> = repository.getAllCountries()

}
