package com.kakao.library_profile_20200819

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_view_profile_photo.*

class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        profilePhotoImg.setOnClickListener {
//            사진을 크게보이는 별도의 액티비티로 이동
            val myIntent = Intent(mContext, ViewProfilePhotoActivity::class.java)
            startActivity(myIntent)
        }

    }

    override fun setValues() {

        Glide.with(mContext)
            .load("https://img.extmovie.com/files/attach/images/148/767/645/051/cf71cbb965d6ee8273da5602f255eb74.jpg")
            .into(profilePhotoImg);

    }

}