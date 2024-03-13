package com.example.solutionx.features.helper.data.mapper

import com.example.solutionx.features.helper.data.Entity.Country
import com.example.solutionx.features.helper.data.Entity.Filter

fun Filter.toFilter() = com.example.solutionx.features.helper.domain.model.Filter(
    id = id,
    name = name,
    )