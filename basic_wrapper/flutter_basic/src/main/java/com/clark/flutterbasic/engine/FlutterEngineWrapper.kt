package com.clark.flutterbasic.engine

import android.app.Activity
import io.flutter.FlutterInjector
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineGroup
import io.flutter.embedding.engine.dart.DartExecutor

class FlutterEngineWrapper(
    activity: Activity,
    entrypoint: String,
    route: String?
) {
    val engine: FlutterEngine

    init {
        val dartEntrypoint =
            DartExecutor.DartEntrypoint(
                FlutterInjector.instance().flutterLoader().findAppBundlePath(),
                entrypoint
            )
        engine = FlutterEngineGroupWrapper.flutterEngineGroup!!.createAndRunEngine(
            FlutterEngineGroup
                .Options(activity)
                .setDartEntrypoint(dartEntrypoint)
                .setInitialRoute(route)
        )
    }
}
