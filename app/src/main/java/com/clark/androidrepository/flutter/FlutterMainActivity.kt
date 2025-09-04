package com.clark.androidrepository.flutter

import android.content.Intent
import android.os.Bundle
import android.view.View
import com.clark.androidrepository.R
import com.clark.baseui.activity.CBaseActivity
import com.clark.flutterbasic.FlutterBaseActivity

/**
 * 调试 Flutter 相关页面的入口页面
 */
class FlutterMainActivity: CBaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_flutter_main)

        findViewById<View>(R.id.btn_go_flutter_activity).setOnClickListener {
            val intent = Intent(this, TestFlutterActivity::class.java)
            intent.putExtra(FlutterBaseActivity.PATH, "/home")
            startActivity(intent)
        }

        findViewById<View>(R.id.btn_go_flutter_fragment_in_activity).setOnClickListener {
            val intent =
                Intent(this, TestFlutterFragmentInActivity::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.btn_go_flutter_view_in_activity).setOnClickListener {
            val intent =
                Intent(this, TestFlutterViewInActivity::class.java)
            startActivity(intent)
        }

        findViewById<View>(R.id.btn_test_flutter_router).setOnClickListener {
            val intent =
                Intent(this, TestFlutterRouterActivity::class.java)
            intent.putExtra(FlutterBaseActivity.PATH, "/")
//            intent.putExtra(FlutterBaseActivity.PATH, "/home")
            //                intent.putExtra(FlutterBaseActivity.PATH, "/testPage1");
            //                intent.putExtra(FlutterBaseActivity.PATH, "/testPage2");
            startActivity(intent)
        }
    }

}