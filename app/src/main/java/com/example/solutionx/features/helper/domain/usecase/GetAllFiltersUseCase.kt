package com.example.solutionx.features.helper.domain.usecase

import android.content.Context
import com.example.solutionx.features.helper.domain.model.Filter
import com.example.solutionx.features.helper.domain.repository.Repository
import javax.inject.Inject

class GetAllFiltersUseCase @Inject constructor(
    private val repository: Repository,
) {
    operator fun invoke(context: Context): List<Filter> = repository.getAllFilters(context)

}