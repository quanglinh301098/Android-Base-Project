package com.linhpham.goodnight.base

import androidx.lifecycle.ViewModel
import com.google.gson.Gson
import com.linhpham.goodnight.model.Resource
import retrofit2.HttpException

abstract class BaseViewModel :ViewModel(){

    private fun <T> error(message: String, code: Int): Resource<T> {
        return Resource.error(message, code)
    }

    protected suspend fun <T> getResult(call: suspend () -> T): Resource<T> {
        return try {
            val response = call.invoke()
            Resource.success(response)
        } catch (e: Throwable) {
            processError(e)
        }
    }

    private fun  <T> processError(e: Throwable):Resource<T>{
        return if (e is HttpException) {
            e.toError()
        } else {
            error(
                e.message ?: e.toString(),
                if (e is HttpException) e.code() else -1
            )
        }
    }

    companion object {
        fun <T> HttpException.toError(): Resource<T> {
            return try{
                val json = this.response()?.errorBody()?.bytes()?.toString(Charsets.UTF_8)
                if (json != null) {
                    val error = Gson().fromJson(json, Error::class.java)
                    error(" ${error.message}", this.response()?.code() ?: this.code())
                } else {
                    error(this.message ?: this.toString(), this.code())
                }
            }catch (e:Throwable){
                error(this.message ?: this.toString(), this.code())
            }
        }

        private fun <T> error(message: String, code: Int): Resource<T> {
            return Resource.error(message, code)
        }
    }
}
