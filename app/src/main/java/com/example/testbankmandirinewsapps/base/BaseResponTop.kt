package com.example.testbankmandirinewsapps.base

import com.google.gson.annotations.SerializedName
import com.example.testbankmandirinewsapps.model.Model

class BaseResponTop <T>: Model(){

    @SerializedName("sources")
    val sources:T?=null
}