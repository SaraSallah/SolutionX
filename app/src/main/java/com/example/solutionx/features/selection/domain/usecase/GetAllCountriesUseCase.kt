package com.example.solutionx.features.selection.domain.usecase

import com.example.solutionx.features.selection.domain.model.Country
import com.example.solutionx.features.selection.domain.repository.HelperRepository
import javax.inject.Inject

class GetAllCountriesUseCase @Inject constructor(
    private val repository: HelperRepository,
) {
    operator fun invoke(): List<Country> = repository.getAllCountries()

}
