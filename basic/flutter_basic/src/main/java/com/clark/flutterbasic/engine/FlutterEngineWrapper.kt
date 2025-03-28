package com.clark.flutterbasic.engine

import android.app.Activity
import io.flutter.FlutterInjector
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineGroup
import io.flutter.embedding.engine.dart.DartExecutor

class FlutterEngineWrapper(
    activity: Activity,
    delegate: FlutterEngineWrapperDelegate?,
    entrypoint: String,
    route: String?
) {
    val engine: FlutterEngine
    val delegate: FlutterEngineWrapperDelegate?

    init {
        val dartEntrypoint =
            DartExecutor.DartEntrypoint(
                FlutterInjector.instance().flutterLoader().findAppBundlePath(),
                entrypoint
            )
        engine = FlutterEngineGroupInit.flutterEngineGroup!!.createAndRunEngine(
            FlutterEngineGroup
                .Options(activity)
                .setDartEntrypoint(dartEntrypoint)
                .setInitialRoute(route)
        )
        this.delegate = delegate
    }

    fun attach() {

    }

    fun detach() {

    }
}

interface FlutterEngineWrapperDelegate {
    fun onNext()
}
