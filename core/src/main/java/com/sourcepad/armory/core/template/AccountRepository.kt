package com.sourcepad.armory.core.template

import com.sourcepad.armory.core.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.withContext
import kotlinx.coroutines.yield


class AccountRepository {


//    suspend fun get() = flow<Resource<T>> {
//        //Add cached data
//        emit(Resource.Loading())
//        try {
////            emit(Resource.Success(""))
//        } catch (e: Exception) {
//            emit(Resource.Error(e.message ?: "Error"))
//        }
//    }


    fun login(username: String, password: String) = flow<Resource<Unit>> {

        emit(Resource.Loading())

        try {
            emit(Resource.Success(Unit))
        } catch (e: Exception) {
            emit(Resource.Error(e.localizedMessage?:""))
        }

    }


    fun logout() = flow<Resource<Unit>> {

    }


}