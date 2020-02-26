package com.sourcepad.armory.core


sealed class PagedResource<T>(
    val data: T? = null,
    val page: Int
) {
    class Success<T>(data: T, page: Int) : PagedResource<T>(data, page)
    class Loading<T>(data: T? = null, page: Int) : PagedResource<T>(data, page)
    class Error<T>(message: String, page: Int, data: T? = null, val error: Throwable? = null) :
        PagedResource<T>(data, page)
}

sealed class Resource<T>(
    val data: T? = null
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(val message: String, val error: Throwable? = null) : Resource<T>()
}