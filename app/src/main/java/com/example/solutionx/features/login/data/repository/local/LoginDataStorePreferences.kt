package com.example.solutionx.features.login.data.repository.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.solutionx.features.login.data.models.entity.UserEntity
import com.example.solutionx.features.login.domain.repository.local.LoginLocalDS
import com.google.gson.Gson

class LoginDataStorePreferences (context: Context):LoginLocalDS {
    companion object {
        private const val PREFERENCES_FILE_NAME = "SolutionX"
        private val ACCESS_TOKE_KEY =
            stringPreferencesKey("access_token")
        private val USER_INFO_KEY = stringPreferencesKey("user_info")
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

    override suspend fun saveUserInfo(user: UserEntity) {
        val gson = Gson()
        val userGson = gson.toJson(user)

        prefDataStore.edit { preferences ->
            preferences[ACCESS_TOKE_KEY] = userGson
        }

    }


}