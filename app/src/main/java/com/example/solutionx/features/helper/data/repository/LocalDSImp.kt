package com.example.solutionx.features.helper.data.repository

import android.content.Context
import com.example.solutionx.features.helper.data.Entity.Country
import com.example.solutionx.features.helper.data.Entity.Currency
import com.example.solutionx.features.helper.data.Entity.Filter
import com.example.solutionx.features.helper.domain.repository.LocalDs

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import javax.inject.Inject

class LocalDSImp @Inject constructor() : LocalDs {
    override fun getAllCountries(context: Context): List<Country> =
        parseJsonFile(context, "countries.json")

    override fun getAllCurrencies(context: Context): List<Currency> =
        parseJsonFile(context, "currencies.json")

    override fun getAllFilters(context: Context): List<Filter> =
        parseJsonFile(context, "filters.json")

    private inline fun <reified T> parseJsonFile(
        context: Context, fileName: String,
    ): List<T> {
        val jsonString = context.assets.open(fileName).bufferedReader().use { it.readText() }
        val gson = Gson()
        val jsonObject = JSONObject(jsonString)
        val dataArray = jsonObject.getJSONArray("data")
        val itemType = object : TypeToken<T>() {}.type
        val itemList: MutableList<T> = mutableListOf()

        for (i in 0 until dataArray.length()) {
            val itemJson = dataArray.getJSONObject(i).toString()
            val item: T = gson.fromJson(itemJson, itemType)
            itemList.add(item)
        }

        return itemList
    }
}