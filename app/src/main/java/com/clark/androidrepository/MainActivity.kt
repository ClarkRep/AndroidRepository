package com.clark.androidrepository;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.clark.androidrepository.flutter.TestFlutterActivity;
import com.clark.androidrepository.flutter.TestFlutterFragmentInActivity;
import com.clark.androidrepository.flutter.TestFlutterRouterActivity;
import com.clark.androidrepository.flutter.TestFlutterViewInActivity;
import com.clark.flutterbasic.FlutterBaseActivity;


public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_go_flutter_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestFlutterActivity.class);
                intent.putExtra(FlutterBaseActivity.PATH, "/home");
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_go_flutter_fragment_in_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestFlutterFragmentInActivity.class);
                intent.putExtra(FlutterBaseActivity.PATH, "/home");
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_go_flutter_view_in_activity).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestFlutterViewInActivity.class);
                intent.putExtra(FlutterBaseActivity.PATH, "/home");
                startActivity(intent);
            }
        });

        findViewById(R.id.btn_test_flutter_router).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, TestFlutterRouterActivity.class);
                intent.putExtra(FlutterBaseActivity.PATH, "/");
//                intent.putExtra(FlutterBaseActivity.PATH, "/testPage1");
//                intent.putExtra(FlutterBaseActivity.PATH, "/testPage2");
                startActivity(intent);
            }
        });
    }
}