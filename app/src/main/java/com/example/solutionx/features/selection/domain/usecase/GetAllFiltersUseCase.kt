package com.example.solutionx.features.selection.domain.usecase

import com.example.solutionx.features.selection.domain.model.Filter
import com.example.solutionx.features.selection.domain.repository.HelperRepository
import javax.inject.Inject

class GetAllFiltersUseCase @Inject constructor(
    private val repository: HelperRepository,
) {
    operator fun invoke(): List<Filter> = repository.getAllFilters()

}