package com.clark.flutterbasic.engine

import android.app.Application
import io.flutter.embedding.engine.FlutterEngineGroup

/**
 * Flutter 引擎初容器始化包装类，需要放到Application中初始化
 */
object FlutterEngineGroupWrapper {

    @JvmStatic
    var flutterEngineGroup: FlutterEngineGroup? = null

    @JvmStatic
    fun initEngineGroup(application: Application) {
        flutterEngineGroup = FlutterEngineGroup(application)
    }

}