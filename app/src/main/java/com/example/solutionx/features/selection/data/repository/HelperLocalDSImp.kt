package com.example.solutionx.features.selection.data.repository

import android.content.Context
import com.example.solutionx.features.selection.data.Entity.Country
import com.example.solutionx.features.selection.data.Entity.Currency
import com.example.solutionx.features.selection.data.Entity.Filter
import com.example.solutionx.features.selection.domain.repository.HelperLocalDs

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import org.json.JSONObject
import java.io.BufferedReader
import java.io.InputStreamReader
import javax.inject.Inject

class HelperLocalDSImp @Inject constructor(
    val context: Context
) : HelperLocalDs {
    override fun getAllCountries(): List<Country> =
        parseJsonFile( "countries.json")

    override fun getAllCurrencies(): List<Currency> =
        parseJsonFile( "currencies.json")

    override fun getAllFilters(): List<Filter> =
        parseJsonFile( "filters.json")

    private inline fun <reified T> parseJsonFile(fileName: String): List<T> {
        val itemList: MutableList<T> = mutableListOf()
        try {
            context.assets.open(fileName).use { inputStream ->
                val reader = BufferedReader(InputStreamReader(inputStream))
                val jsonString = StringBuilder()
                var line: String? = reader.readLine()
                while (line != null) {
                    jsonString.append(line)
                    line = reader.readLine()
                }
                val dataArray = JSONObject(jsonString.toString()).optJSONArray("data")
                dataArray?.let {
                    val gson = Gson()
                    val itemType = object : TypeToken<T>() {}.type
                    for (i in 0 until dataArray.length()) {
                        val itemJson = dataArray.getJSONObject(i).toString()
                        val item: T = gson.fromJson(itemJson, itemType)
                        itemList.add(item)
                    }
                } ?: run {
                    println("No data array found in JSON for $fileName")
                }
            }
        } catch (e: Exception) {
            println("Error parsing JSON file: $fileName")
            e.printStackTrace()
        }
        return itemList
    }
}