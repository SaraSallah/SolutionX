package com.example.solutionx.features.helper.domain.usecase

import android.content.Context
import com.example.solutionx.features.helper.domain.model.Filter
import com.example.solutionx.features.helper.domain.repository.HelperRepository
import javax.inject.Inject

class GetAllFiltersUseCase @Inject constructor(
    private val repository: HelperRepository,
) {
    operator fun invoke(): List<Filter> = repository.getAllFilters()

}