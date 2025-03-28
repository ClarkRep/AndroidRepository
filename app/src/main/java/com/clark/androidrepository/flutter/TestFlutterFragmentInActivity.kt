package com.clark.androidrepository.flutter

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.clark.androidrepository.R
import com.clark.flutterbasic.FlutterFragmentManager

/**
 * 测试：在Activity中使用FlutterFragment
 */
class TestFlutterFragmentInActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_flutter_fragment)

        FlutterFragmentManager.addFlutterFragmentToContainer(
            this,
            "/",
            R.id.fl_flutter_fragment_container,
            "flutter_fragment"
        )
    }
}