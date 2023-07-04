package com.example.testbankmandirinewsapps.base

import android.app.Dialog
import android.content.Context
import android.content.SharedPreferences
import android.widget.ProgressBar
import androidx.fragment.app.FragmentManager
import com.facebook.shimmer.ShimmerFrameLayout
import com.example.testbankmandirinewsapps.dummy.Category
//import com.facebook.shimmer.ShimmerFrameLayout
import com.example.testbankmandirinewsapps.model.Model
import com.example.testbankmandirinewsapps.service.API
import com.example.testbankmandirinewsapps.utilitas.MyCallback
import retrofit2.Call
import retrofit2.Callback

interface BaseUI {
    val ctx:Context?
    val dialog:Dialog?
    val shimmeringLoading: ShimmerFrameLayout?
    val progressBar:ProgressBar?
    val api: API

    fun<T: Model> callApi(call: Call<T>, callback: MyCallback<T>)
    fun<T> callApi(call: Call<T>, callback: Callback<T>)

    val dataDummy: List<Category>?
}