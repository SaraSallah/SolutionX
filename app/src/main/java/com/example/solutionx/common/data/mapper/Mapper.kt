package com.example.solutionx.common.data.mapper

interface Mapper<I, O> {
    fun map(input: I): O
}
