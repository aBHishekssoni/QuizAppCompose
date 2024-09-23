package com.abhishek_soni.quizappcompose.common

sealed class Resource<T>(
     data: T? = null
     ,message: String? = null
) {
     class Loading<T> : Resource<T>()
    class Success<T>(val data: T?) : Resource<T>(data = data)
    class Error <T> (val message: String?) : Resource<T>(message = message)

}