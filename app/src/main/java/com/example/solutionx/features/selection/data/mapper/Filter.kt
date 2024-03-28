package com.example.solutionx.features.selection.data.mapper

import com.example.solutionx.features.selection.data.Entity.Filter

fun Filter.toFilter() = com.example.solutionx.features.selection.domain.model.Filter(
    id = id,
    name = name,
    )