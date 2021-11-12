package com.sourcepad.armory.core.repository


interface AccountRepository {

    suspend fun login(username: String, password: String)

    suspend fun logout()

}