package com.example.solutionx.features.login.data.repository.local

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.solutionx.features.login.data.models.entity.UserEntity
import com.example.solutionx.features.login.domain.repository.local.LoginLocalDS
import com.example.solutionx.utils.Constant
import com.google.gson.Gson
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

class LoginDataStorePreferences (context: Context):LoginLocalDS {
    companion object {
        private const val PREFERENCES_FILE_NAME = Constant.DATA_STORE_FILE
        private val ACCESS_TOKE_KEY =
            stringPreferencesKey(Constant.ACCESS_TOKEN_KEY)
        private val USER_INFO_KEY = stringPreferencesKey(Constant.USER_INFO_KEY)
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
            preferences[USER_INFO_KEY] = userGson
        }

    }

    override suspend fun getUSerInfo(): UserEntity {
        val userGson = prefDataStore.data.map {
            it[USER_INFO_KEY]
        }.first()
        val gson = Gson()
        return gson.fromJson(userGson, UserEntity::class.java)
    }


}