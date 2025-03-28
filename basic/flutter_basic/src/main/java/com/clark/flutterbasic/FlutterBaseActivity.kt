package com.clark.flutterbasic

import android.content.Context
import android.os.Bundle
import com.clark.flutterbasic.engine.FlutterEngineWrapper
import com.clark.flutterbasic.engine.FlutterEngineWrapperDelegate
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.renderer.FlutterUiDisplayListener

/**
 *  用来承接Flutter页面的Activity容器，包含Flutter引擎和Channel的初始化
 */
open class FlutterBaseActivity : FlutterActivity(), FlutterEngineWrapperDelegate {

    companion object {
        const val TAG = "FlutterBaseActivity"
        const val PATH = "flutter_page_path"
    }

    protected var routePath: String = "/"

    var engineWrapper: FlutterEngineWrapper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState != null) {
            routePath = savedInstanceState.getString(PATH, "/")
        } else {
            routePath = intent.getStringExtra(PATH) ?: "/"
        }
    }

    override fun provideFlutterEngine(context: Context): FlutterEngine? {
        if (engineWrapper == null) {
            routePath = intent.getStringExtra(PATH)?: "/"
//            Logger.i(TAG, "provideFlutterEngine routePath = $routePath", true)
            // 创建Flutter引擎实例，传入路由地址：routePath
            engineWrapper = FlutterEngineWrapper(this, this, "main", routePath)
            initChannel()
        }

        // 监听Flutter渲染状态
        engineWrapper!!.engine.getRenderer()
            .addIsDisplayingFlutterUiListener(object : FlutterUiDisplayListener {
                override fun onFlutterUiDisplayed() {
                    // Flutter 开始渲染
//                    Logger.i(TAG, "FlutterBaseFragmentActivity onFlutterUiDisplayed", true)
                }

                override fun onFlutterUiNoLongerDisplayed() {
                    // Flutter 停止渲染
//                    Logger.i(TAG, "FlutterBaseFragmentActivity onFlutterUiNoLongerDisplayed", true)
                }
            })
        return engineWrapper!!.engine
    }

    override fun onNext() {

    }

    /**
     * 加载引擎Channel (通用 + 自定义)
     */
    private fun initChannel() {
//        initEngineCommonChannel()
//        initEngineCustomChannel()
    }

}