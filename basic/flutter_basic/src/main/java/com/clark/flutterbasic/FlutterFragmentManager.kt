package com.clark.flutterbasic

import androidx.fragment.app.FragmentActivity
import io.flutter.embedding.android.FlutterFragment

/**
 * 用来加载 FlutterFragment 到封装类
 */
object FlutterFragmentManager {

    @JvmStatic
    fun addFlutterFragmentToContainer(
        fragmentActivity: FragmentActivity,
        flutterPathRoute: String,
        containerId: Int,
        fragmentTag: String
    ) {
        val flutterFragment = FlutterFragment
            .withNewEngine()
            .initialRoute(flutterPathRoute)
            .build<FlutterFragment>()

        fragmentActivity
            .supportFragmentManager
            .beginTransaction()
            .replace(containerId, flutterFragment, fragmentTag)
            .commit()
    }

}