package com.clark.androidrepository.application

import android.app.Application
import com.clark.flutterbasic.engine.FlutterEngineGroupWrapper

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        // 初始化Flutter引擎容器
        FlutterEngineGroupWrapper.initEngineGroup(this)
    }

}