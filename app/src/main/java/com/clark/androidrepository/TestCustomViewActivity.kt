package com.clark.androidrepository

import android.os.Bundle
import com.clark.baseui.activity.CBaseActivity

class TestCustomViewActivity :CBaseActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test_custom_view)
    }

}
