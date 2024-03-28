package com.example.solutionx.common.data.repository.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.floatPreferencesKey
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

class DataStorePreferences(context: Context)  {
    companion object {
        private const val PREFERENCES_FILE_NAME = "SolutionX"
    }

    private val Context.preferencesDataStore: DataStore<Preferences>
            by preferencesDataStore(DataStorePreferences.PREFERENCES_FILE_NAME)
    private val prefDataStore = context.preferencesDataStore

     suspend fun <T> save(key: String, value: T) {
        val preferencesKey = stringPreferencesKey(key)
        prefDataStore.edit { preferences ->
            when (value) {
                is String -> preferences[stringPreferencesKey(key)] = value
                is Boolean -> preferences[booleanPreferencesKey(key)] = value
                is Int -> preferences[intPreferencesKey(key)] = value
                is Float -> preferences[floatPreferencesKey(key)] = value
                is Long -> preferences[longPreferencesKey(key)] = value
                else -> preferences[stringPreferencesKey(key)] =value.toString()
            }
        }

     }

     fun <T> get(key: String): T {
        return runBlocking {
            val value: Any? = prefDataStore.data.map { preferences ->
                preferences[stringPreferencesKey(key)] ?:
                preferences[booleanPreferencesKey(key)] ?:
                preferences[intPreferencesKey(key)] ?:
                preferences[longPreferencesKey(key)] ?:
                preferences[floatPreferencesKey(key)]
            }.first()

            @Suppress("UNCHECKED_CAST")
            value as T ?: throw IllegalStateException("Value for key $key not found")


        }

     }


}