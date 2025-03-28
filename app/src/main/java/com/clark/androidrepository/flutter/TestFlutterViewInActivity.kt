package com.clark.androidrepository.flutter

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.clark.androidrepository.R
import com.clark.flutterbasic.engine.FlutterEngineWrapper
import io.flutter.embedding.android.FlutterView
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

/**
 * 测试：在Activity中使用FlutterView
 */
class TestFlutterViewInActivity : AppCompatActivity() {

    private lateinit var flutterView: FlutterView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_flutter_view)

        flutterView = findViewById<FlutterView>(R.id.flutter_view)
        // flutterView里面的 flutter组建点击事件无响应，添加下面这些也没用，需要再研究研究
        flutterView.setFocusable(true)
        flutterView.setFocusableInTouchMode(true)
        flutterView.requestFocus()

        // 创建 FlutterEngine
        val flutterEngineWrapper = FlutterEngineWrapper(this, null, "main", "/")
        // 将FlutterEngine绑定到FlutterView
        flutterView.attachToFlutterEngine(flutterEngineWrapper.engine)


//        initFlutterEngine()
//
//        // 从缓存获取 FlutterEngine
//        val flutterEngine = FlutterEngineCache
//            .getInstance()
//            .get("cached_engine_id")
//        // 将FlutterEngine绑定到FlutterView
//        flutterView.attachToFlutterEngine(flutterEngine!!)
    }

    private fun initFlutterEngine() {
        // 创建Flutter引擎实例
        val flutterEngine = FlutterEngine(this).apply {
            // 自定义路由
            navigationChannel.setInitialRoute("/")
            dartExecutor.executeDartEntrypoint(
                DartExecutor.DartEntrypoint.createDefault()
            )
        }

        // 缓存FlutterEngine，后续可直接使用
        FlutterEngineCache
            .getInstance()
            .put("cached_engine_id", flutterEngine)
    }

    override fun onDestroy() {
        // 从FlutterView被回收时detach，防止内存泄漏
        flutterView.detachFromFlutterEngine()
        super.onDestroy()
    }
}