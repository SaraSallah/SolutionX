package com.example.solutionx.features.helper.data

import com.example.solutionx.features.login.data.models.Entity.Country
import com.example.solutionx.features.login.data.models.Entity.Currency
import com.example.solutionx.features.login.data.models.Entity.Filter
import com.google.gson.Gson
import com.google.gson.JsonParser
import com.google.gson.reflect.TypeToken

class Repository {

    fun getAllCurrency():List<Currency>{
        val currencyJsonString = """
    {
      "data": [
        {
          "id": 1,
          "name": "American Dollar",
          "sign": "${'$'}",
          "code": "USD"
        },
        {
          "id": 2,
          "name": "Euro",
          "sign": "\u20ac",
          "code": "EUR"
        },
        {
          "id": 3,
          "name": "Egyptian Pound",
          "sign": "LE",
          "code": "EGP"
        },
        {
          "id": 4,
          "name": "Saudi Riyal",
          "sign": "SAR",
          "code": "SAR"
        },
        {
          "id": 5,
          "name": "Emirati Dirham",
          "sign": "AED",
          "code": "AED"
        },
        {
          "id": 6,
          "name": "Kuwaiti Dinar",
          "sign": "KWD",
          "code": "KWD"
        },
        {
          "id": 7,
          "name": "Qatari Riyal",
          "sign": "QAR",
          "code": "QAR"
        },
        {
          "id": 8,
          "name": "Bahraini Dinar",
          "sign": "BHD",
          "code": "BHD"
        },
        {
          "id": 9,
          "name": "Omani Riyal",
          "sign": "OMR",
          "code": "OMR"
        }
      ]
    }
""".trimIndent()
        return parseJsonString(currencyJsonString, "data")
    }

    fun getAllFilter():List<Filter>{
        val filterJsonString = """
            {
              "data": [
                {
                  "id": 1,
                  "name": "test title 2"
                },
                {
                  "id": 3,
                  "name": "\u0639\u0631\u0628\u06492222"
                }
              ]
            }
        """.trimIndent()
        return parseJsonString(filterJsonString, "data")

    }

    fun getAllCountry():List<Country>{
        val countryJsonString ="""
            {
              "data": [
                {
                  "id": 1,
                  "name": "Saudi Arabia",
                  "currency": "SAR",
                  "code": "sa",
                  "phone_code": "00966",
                  "flag": "\ud83c\uddf8\ud83c\udde6"
                },
                {
                  "id": 2,
                  "name": "Egypt",
                  "currency": "EGP",
                  "code": "eg",
                  "phone_code": "0020",
                  "flag": "\ud83c\uddea\ud83c\uddec"
                },
                {
                  "id": 3,
                  "name": "Afghanistan",
                  "currency": "AFN",
                  "code": "af",
                  "phone_code": "0093",
                  "flag": "\ud83c\udde6\ud83c\uddeb"
                },
                {
                  "id": 4,
                  "name": "Albania",
                  "currency": "ALL",
                  "code": "al",
                  "phone_code": "00355",
                  "flag": "\ud83c\udde6\ud83c\uddf1"
                },
                {
                  "id": 5,
                  "name": "Algeria",
                  "currency": "DZD",
                  "code": "dz",
                  "phone_code": "00213",
                  "flag": "\ud83c\udde9\ud83c\uddff"
                },
                {
                  "id": 6,
                  "name": "Andorra",
                  "currency": "EUR",
                  "code": "ad",
                  "phone_code": "00376",
                  "flag": "\ud83c\udde6\ud83c\udde9"
                },
                {
                  "id": 7,
                  "name": "Angola",
                  "currency": "AOA",
                  "code": "ao",
                  "phone_code": "00244",
                  "flag": "\ud83c\udde6\ud83c\uddf4"
                },
                {
                  "id": 8,
                  "name": "Argentina",
                  "currency": "ARS",
                  "code": "ar",
                  "phone_code": "0054",
                  "flag": "\ud83c\udde6\ud83c\uddf7"
                },
                {
                  "id": 9,
                  "name": "Armenia",
                  "currency": "AMD",
                  "code": "am",
                  "phone_code": "00374",
                  "flag": "\ud83c\udde6\ud83c\uddf2"
                }
              ]
            }
        """.trimIndent()
        return parseJsonString(countryJsonString, "data")
    }

    private inline fun <reified T> parseJsonString(jsonString: String, key: String): List<T> {
        val gson = Gson()
        val jsonObject = JsonParser.parseString(jsonString).asJsonObject
        val dataArray = jsonObject.getAsJsonArray(key)
        return gson.fromJson(dataArray, object : TypeToken<List<T>>() {}.type)
    }

}
