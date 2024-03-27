package com.example.solutionx.common.data.repository.local

import android.content.Context

class SharedPreferences(context: Context) : LocalDataStoreProvider {

    private val sharedPreferences =
        context.getSharedPreferences("SolutionX", Context.MODE_PRIVATE)

    override suspend fun <T> save(key: String, value: T) {
        sharedPreferences.edit().apply {
            when (value) {
                is String -> putString(key, value)
                is Boolean -> putBoolean(key, value)
                is Int -> putInt(key, value)
                is Float -> putFloat(key, value)
                is Long -> putLong(key, value)
                else -> throw IllegalArgumentException("Unsupported type")
            }
            apply()
        }
    }

    override fun <T> get(key: String): T {
        @Suppress("UNCHECKED_CAST") return when (val value = sharedPreferences.all[key]) {
            is String -> value as T
            is Boolean -> value as T
            is Int -> value as T
            is Float -> value as T
            is Long -> value as T
            else -> throw IllegalArgumentException("Unsupported type")
        }
    }
}