package com.example.solutionx.features.helper.data.mapper

import com.example.solutionx.features.helper.data.Entity.Country
import com.example.solutionx.features.helper.data.Entity.Currency

fun Currency.toCurrency() = com.example.solutionx.features.helper.domain.model.Currency(
    id = id,
    name = name,
    code = code,
    sign = sign
    )