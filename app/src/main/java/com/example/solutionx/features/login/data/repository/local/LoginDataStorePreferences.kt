package com.example.solutionx.features.login.data.repository.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.solutionx.features.login.domain.model.User
import com.example.solutionx.features.login.domain.repository.local.LoginLocalDS
import javax.inject.Inject

class LoginDataStorePreferences (context: Context):LoginLocalDS {
    companion object {
        private const val PREFERENCES_FILE_NAME = "SolutionX"
        private val ACCESS_TOKE_KEY =
            stringPreferencesKey("access_token")
    }
     private var storedAccessToken: String? = null

    private val Context.preferencesDataStore: DataStore<androidx.datastore.preferences.core.Preferences>
            by preferencesDataStore(PREFERENCES_FILE_NAME)
    private val prefDataStore = context.preferencesDataStore


    override suspend fun saveAccessToken(token: String) {
        storedAccessToken = null
        prefDataStore.edit { preferences ->
            preferences[ACCESS_TOKE_KEY] = token
        }

    }



}