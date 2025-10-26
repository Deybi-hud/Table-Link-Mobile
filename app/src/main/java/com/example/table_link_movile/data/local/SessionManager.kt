package com.example.table_link_movile.data.local

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map


val Context.dataStore by preferencesDataStore("user_perfs")

class SessionManager(private val context: Context){

    companion object{
        private val USER_UID = stringPreferencesKey("user_uid")
        private val USER_EMAIL = stringPreferencesKey("user_email")
        private val USER_NAME = stringPreferencesKey("user_name")
    }

    val userUidFlow: Flow<String?> = context.dataStore.data.map { prefs ->
        prefs[USER_UID]
    }

    val userNameFlow: Flow<String?> = context.dataStore.data.map { prefs ->
        prefs[USER_NAME]
    }

    val userEmailFlow: Flow<String?> = context.dataStore.data.map { prefs ->
        prefs[USER_EMAIL]
    }

    suspend fun saveUserName(name: String) {
        context.dataStore.edit { prefs -> prefs[stringPreferencesKey("user_name")] = name }
    }

    suspend fun saveUserEmail(email: String){
        context.dataStore.edit { prefs -> prefs[stringPreferencesKey("user_email")] = email}

    }

    suspend fun saveUid(uid: String){
        context.dataStore.edit { prefs -> prefs[USER_UID] = uid}
    }

    suspend fun clearSession(){
        context.dataStore.edit { prefs -> prefs.remove(USER_UID) }
    }

}