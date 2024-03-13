package com.example.solutionx.features.helper.data.mapper

import com.example.solutionx.features.helper.data.Entity.Country

fun Country.toCountry() = com.example.solutionx.features.helper.domain.model.Country(
    id = id,
    name = name,
    currency = currency,
    code = code,
    phone_code = phone_code,
    flag = flag,

    )
