package com.example.testbankmandirinewsapps

import android.app.Dialog
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import com.facebook.shimmer.ShimmerFrameLayout
import com.example.testbankmandirinewsapps.MainActivity
import com.example.testbankmandirinewsapps.R
import com.example.testbankmandirinewsapps.base.BaseUI
import com.example.testbankmandirinewsapps.dummy.Category
import com.example.testbankmandirinewsapps.dummy.CreatDummyData
import com.example.testbankmandirinewsapps.model.Model
import com.example.testbankmandirinewsapps.service.API
import com.example.testbankmandirinewsapps.utilitas.CommonUtils
import com.example.testbankmandirinewsapps.utilitas.MyCallback
import retrofit2.Call
import retrofit2.Callback

abstract class BaseActivity: AppCompatActivity(), BaseUI {

    private var mDialog: Dialog?=null
    private var mFm: FragmentManager?=null
    private var mShimmering: ShimmerFrameLayout?=null
    private var mProgressBar: ProgressBar?=null
  


    override val ctx: Context?
        get() = this

    override val dialog: Dialog?
        get() = mDialog

    override val shimmeringLoading: ShimmerFrameLayout?
        get() = mShimmering
    override val progressBar: ProgressBar?
        get() = mProgressBar

    override val api: API
        get() = MyApp.getApi()

    override val dataDummy: List<Category>?
        get() = CreatDummyData().getMessageCategory(this)

    override fun <T : Model> callApi(call: Call<T>, callback: MyCallback<T>) {
        MyApp.callApi(this, call, callback)
    }

    override fun <T> callApi(call: Call<T>, callback: Callback<T>) {
        MyApp.callApi(this, call, callback)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingView()

//        mRealm = Realm.getDefaultInstance()
        mFm = supportFragmentManager

        mDialog = Dialog(this)

    }

    fun showLoading(msg:String?){
        mDialog?.setContentView(R.layout.dialog_loading)
        mDialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
        val textMessage = mDialog?.findViewById<TextView>(R.id.textLoading)

        if(msg!= null)
            textMessage?.text = msg?:""

        mDialog?.show()
    }

    fun showLoading(){
        showLoading(null)
    }

    fun dismissLoading(){
        mDialog?.dismiss()
    }



    protected open fun bindingView(){
        setContentView(getContentView())
    }

    protected abstract fun getContentView():Int

    override fun onDestroy() {
        super.onDestroy()
        mDialog?.dismiss()
        CommonUtils.hideSoftKeyboard(this)
    }

    abstract fun dataDummy(mainActivity: MainActivity): List<Category>?
}