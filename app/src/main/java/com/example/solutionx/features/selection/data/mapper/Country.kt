package com.example.solutionx.features.selection.data.mapper

import com.example.solutionx.features.selection.data.Entity.Country

fun Country.toCountry() = com.example.solutionx.features.selection.domain.model.Country(
    id = id,
    name = name,
    currency = currency,
    code = code,
    phone_code = phone_code,
    flag = flag,

    )
