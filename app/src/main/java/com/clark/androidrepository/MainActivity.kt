package com.clark.androidrepository

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.clark.androidrepository.flutter.FlutterMainActivity
import com.clark.baseui.activity.CBaseActivity

class MainActivity : CBaseActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.btn_go_test_custom_view_activity).setOnClickListener {
            val intent = Intent(this, TestCustomViewActivity::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.btn_go_flutter_main_activity).setOnClickListener {
            val intent = Intent(this, FlutterMainActivity::class.java)
            startActivity(intent)
        }
    }
}