package com.clark.androididtest;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

/**
 * 测试获取 AndroidId 是否需要声明权限：android.permission.READ_PHONE_STATE
 * 结论：不需要声明、也不需要申请 android.permission.READ_PHONE_STATE，就可以获取到 AndroidId。
 */
public class AndroidIdTestActivity extends AppCompatActivity {

    public static final String TAG = "AndroidIdTestActivity";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_androidid);
        findViewById(R.id.btn_get_androidid).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String androidId = Settings.Secure.getString(getContentResolver(), Settings.Secure.ANDROID_ID);
                Log.i(TAG, "androidId=" + androidId);
            }
        });
    }
}
