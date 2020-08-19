package com.kakao.library_profile_20200819

import androidx.appcompat.app.AppCompatActivity

//STEP1:BaseActivity만들기
abstract class BaseActivity : AppCompatActivity() {
    val mContext = this
    abstract fun setupEvents()
    abstract fun setValues()
}