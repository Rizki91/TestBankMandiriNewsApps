package com.example.testbankmandirinewsapps.service

import androidx.annotation.Keep
import com.example.testbankmandirinewsapps.base.BaseRespon
import com.example.testbankmandirinewsapps.base.BaseResponTop
import com.example.testbankmandirinewsapps.model.ResponseNewNews

import com.example.testbankmandirinewsapps.model.ResponseTopNews
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface API {
    @GET("top-headlines")
    fun getTopHeadlines(
        @Query("q") q:String,
        @Query("country") country:String,
        @Query("category") category:String,
        @Query("apiKey") apiKey:String,
        @Query("pageSize") pageSize:Int,
        @Query("page") page:Int
    ): Call<BaseRespon<List<ResponseNewNews>>>

    @GET("top-headlines/sources")
    fun getTopNews(
        @Query("apiKey") apiKey:String


    ): Call<BaseResponTop<List<ResponseTopNews>>>

}