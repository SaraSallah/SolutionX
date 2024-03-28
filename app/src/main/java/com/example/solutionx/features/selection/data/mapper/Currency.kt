package com.example.solutionx.features.selection.data.mapper

import com.example.solutionx.features.selection.data.Entity.Currency

fun Currency.toCurrency() = com.example.solutionx.features.selection.domain.model.Currency(
    id = id,
    name = name,
    code = code,
    sign = sign
    )