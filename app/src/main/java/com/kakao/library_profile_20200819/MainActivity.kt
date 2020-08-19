package com.kakao.library_profile_20200819

import android.Manifest
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.TedPermission
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }

    override fun setupEvents() {

        callBtn.setOnClickListener {

//            전화기능을 사용가능한상태인지 확인 + 권한요청
            val pl = object : PermissionListener {
                override fun onPermissionGranted() {
//                    권한이 승인된 상태일경우 실행할 코드
//                    Toast.makeText(this@MainActivity, "Permission Granted", Toast.LENGTH_SHORT).show()
//            전화연결처리(ACTION_CALL)
                    val myUri = Uri.parse("tel:010-5555-6666")
                    val myIntent = Intent(Intent.ACTION_CALL, myUri)
                    startActivity(myIntent)

                }

                override fun onPermissionDenied(deniedPermissions: List<String>) {
//                    권한이 최종 거부될경우 실행할 코드
                    Toast.makeText(
                        mContext,
                        "전화 권한이 거부되어 연결이 불가능합니다.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

//            완성된 행동방침을 가지고 권한실제요청
            TedPermission.with(mContext)
                .setPermissionListener(pl)
                .setDeniedMessage("권한을 거부하면 통화가 불가능합니다.\n설정 >  권한을 허용해 주세요")
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()
        }

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