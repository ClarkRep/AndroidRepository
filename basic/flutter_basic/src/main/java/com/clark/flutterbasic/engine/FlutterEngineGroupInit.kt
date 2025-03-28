package com.clark.flutterbasic.engine

import android.app.Application
import io.flutter.embedding.engine.FlutterEngineGroup

/**
 * Flutter 引擎初容器始化包装类，需要放到Application中初始化
 */
object FlutterEngineGroupInit {

    @JvmStatic
    var flutterEngineGroup: FlutterEngineGroup? = null

    @JvmStatic
    fun initEngine(application: Application) {
        flutterEngineGroup = FlutterEngineGroup(application)
    }

}