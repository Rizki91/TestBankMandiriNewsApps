package com.example.testbankmandirinewsapps.base

import com.google.gson.annotations.SerializedName
import com.example.testbankmandirinewsapps.model.Model

class BaseRespon<T>: Model() {

    @SerializedName("articles")
    val articles:T?=null


}