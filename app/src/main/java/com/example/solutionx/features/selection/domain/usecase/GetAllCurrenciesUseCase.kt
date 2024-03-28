package com.example.solutionx.features.selection.domain.usecase

import com.example.solutionx.features.selection.domain.model.Currency
import com.example.solutionx.features.selection.domain.repository.HelperRepository
import javax.inject.Inject

class GetAllCurrenciesUseCase @Inject constructor(
    private val repository: HelperRepository,
) {
    operator fun invoke(): List<Currency> = repository.getAllCurrencies()

}

