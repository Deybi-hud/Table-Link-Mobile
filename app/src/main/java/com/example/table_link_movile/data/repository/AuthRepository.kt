package com.example.table_link_movile.data.repository

import android.content.Context
import com.example.table_link_movile.data.local.SessionManager
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await

class AuthRepository(context: Context) {

    private val auth = FirebaseAuth.getInstance()

    private val sessionManager = SessionManager(context)

    suspend fun login(email: String, password: String): Result<String>{
        return try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            val uid = result.user?.uid ?: return Result.failure(Exception("Invalid user"))

            sessionManager.saveUid(uid)
            Result.success("Login successful")
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun register(email: String, password: String, name: String): Result<String> {
        return try {
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            val uid = result.user?.uid ?: return Result.failure(Exception("Invalid user"))

            sessionManager.saveUid(uid)
            Result.success(uid)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    private suspend fun saveUserName(uid: String, name: String) {
        sessionManager.saveUserName(name)
    }


    suspend fun logout(){
        auth.signOut()
        sessionManager.clearSession()
    }

    fun getUidFlow() = sessionManager.userUidFlow

}