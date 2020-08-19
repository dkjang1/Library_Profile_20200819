package com.kakao.library_profile_20200819

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.activity_view_profile_photo.*

class ViewProfilePhotoActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_profile_photo)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {


    }

    override fun setValues() {

        Glide.with(mContext)
            .load("https://img.extmovie.com/files/attach/images/148/767/645/051/cf71cbb965d6ee8273da5602f255eb74.jpg")
            .into(profilePhoto);
    }

}