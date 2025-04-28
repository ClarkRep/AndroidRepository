package com.clark.storagepermission;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import java.io.File;
import java.io.IOException;

public class AndroidStorageTestActivity extends AppCompatActivity {

    public static final String TAG = "AndroidStorageTestActivity";

    private static final int REQUEST_EXTERNAL_STORAGE_PERMISSION_CODE = 123;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_android_storage);

        initInnerStorage();
        initOuterPrivateStorage();
        initOuterPublicStorage();
        initSystemStorage();
    }

    /**
     * 根据传入的路径，创建test文件，查看是否创建成功
     *
     * @param path
     */
    @SuppressLint("LongLogTag")
    private void makeFile(String path) {
        File file = new File(path + "/test");
        if (file.exists()) {
            file.delete();
        }
        try {
            boolean newFile = file.createNewFile();
            Log.i(TAG, "createNewFile()->result=" + newFile);
        } catch (IOException e) {
            Log.e(TAG, "createNewFile()->exception=" + e.getMessage());
        }
    }

    /**
     * 是否有外部存储写权限
     *
     * @return
     */
    private boolean hasExternalStorageWritePermission() {
        return ContextCompat.checkSelfPermission(AndroidStorageTestActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;
//        return true;
    }

    /**
     * 请求外部存储写权限
     */
    private void requestExternalStorageWritePermission() {
        ActivityCompat.requestPermissions(AndroidStorageTestActivity.this,
                new String[]{Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE},
                REQUEST_EXTERNAL_STORAGE_PERMISSION_CODE);
    }

    private void initInnerStorage() {
        findViewById(R.id.btn_inner_data_dir).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(View v) {
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    File dataDir = getDataDir();
                    Log.i(TAG, "获取内部存储：context.getDataDir()=" + dataDir.getAbsolutePath());
                    makeFile(dataDir.getAbsolutePath());
                }
            }
        });
        findViewById(R.id.btn_inner_file_dir).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(View v) {
                File filesDir = getFilesDir();
                Log.i(TAG, "获取内部存储：context.getFilesDir()=" + filesDir.getAbsolutePath());
                makeFile(filesDir.getAbsolutePath());
            }
        });
        findViewById(R.id.btn_inner_cache_dir).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(View v) {
                File cacheDir = getCacheDir();
                Log.i(TAG, "获取内部存储：context.getCacheDir()=" + cacheDir.getAbsolutePath());
                makeFile(cacheDir.getAbsolutePath());
            }
        });
    }

    private void initOuterPrivateStorage() {
        findViewById(R.id.btn_out_private_cache_dir).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(View v) {
                File externalCacheDir = getExternalCacheDir();
                Log.i(TAG, "获取外部存储（私有）：context.getExternalCacheDir()=" + externalCacheDir.getAbsolutePath());
                makeFile(externalCacheDir.getAbsolutePath());
            }
        });
        findViewById(R.id.btn_out_private_cache_dirs).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(View v) {
                File[] externalCacheDirs = getExternalCacheDirs();
                for (File externalCacheDir : externalCacheDirs) {
                    Log.i(TAG, "获取外部存储（私有）：context.getExternalCacheDirs()=" + externalCacheDir.getAbsolutePath());
                    makeFile(externalCacheDir.getAbsolutePath());
                }
            }
        });
        findViewById(R.id.btn_out_private_files_dir).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(View v) {
                File externalFilesDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                Log.i(TAG, "获取外部存储（私有）：context.getExternalFilesDir(String type)=" + externalFilesDir.getAbsolutePath());
                makeFile(externalFilesDir.getAbsolutePath());
            }
        });
        findViewById(R.id.btn_out_private_files_dirs).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(View v) {
                File[] externalFilesDirs = getExternalFilesDirs(Environment.DIRECTORY_PICTURES);
                for (File externalFilesDir : externalFilesDirs) {
                    Log.i(TAG, "获取外部存储（私有）：context.getExternalFilesDirs(String type)=" + externalFilesDir.getAbsolutePath());
                    makeFile(externalFilesDir.getAbsolutePath());
                }
            }
        });
        findViewById(R.id.btn_out_private_media_dirs).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(View v) {
                File[] externalMediaDirs = getExternalMediaDirs();
                for (File externalMediaDir : externalMediaDirs) {
                    Log.i(TAG, "获取外部存储（私有）：context.getExternalMediaDirs()=" + externalMediaDir.getAbsolutePath());
                    makeFile(externalMediaDir.getAbsolutePath());
                }
            }
        });
    }

    private void initOuterPublicStorage() {
        findViewById(R.id.btn_out_public_external_storage_state).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(View v) {
                String externalStorageState = Environment.getExternalStorageState();
                Log.i(TAG, "获取外部存储（公用）：Environment.getExternalStorageState()=" + externalStorageState);
            }
        });
        findViewById(R.id.btn_out_public_external_storage_dir).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(View v) {
                if (hasExternalStorageWritePermission()) {
                    // 权限已经授予，可以进行相关操作
                    File externalStorageDirectory = Environment.getExternalStorageDirectory();
                    Log.i(TAG, "获取外部存储（公用）：Environment.getExternalStorageDirectory()=" + externalStorageDirectory.getAbsolutePath());
                    makeFile(externalStorageDirectory.getAbsolutePath());
                } else {
                    // 权限未授予，需要向用户申请权限
                    requestExternalStorageWritePermission();
                }
            }
        });
        findViewById(R.id.btn_out_public_external_storage_public_dir).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(View v) {
                if (hasExternalStorageWritePermission()) {
                    // 权限已经授予，可以进行相关操作
                    File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                    Log.i(TAG, "获取外部存储（公用）：Environment.getExternalStoragePublicDirectory()=" + externalStoragePublicDirectory.getAbsolutePath());
                    makeFile(externalStoragePublicDirectory.getAbsolutePath());
                } else {
                    // 权限未授予，需要向用户申请权限
                    requestExternalStorageWritePermission();
                }
            }
        });
    }

    private void initSystemStorage() {
        findViewById(R.id.btn_system_root_directory).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(View v) {
                if (hasExternalStorageWritePermission()) {
                    // 权限已经授予，可以进行相关操作
                    File rootDirectory = Environment.getRootDirectory();
                    Log.i(TAG, "系统存储：Environment.getRootDirectory()=" + rootDirectory.getAbsolutePath());
                    makeFile(rootDirectory.getAbsolutePath());
                } else {
                    // 权限未授予，需要向用户申请权限
                    requestExternalStorageWritePermission();
                }
            }
        });
        findViewById(R.id.btn_system_data_directory).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(View v) {
                if (hasExternalStorageWritePermission()) {
                    // 权限已经授予，可以进行相关操作
                    File dataDirectory = Environment.getDataDirectory();
                    Log.i(TAG, "系统存储：Environment.getDataDirectory()=" + dataDirectory.getAbsolutePath());
                    makeFile(dataDirectory.getAbsolutePath());
                } else {
                    // 权限未授予，需要向用户申请权限
                    requestExternalStorageWritePermission();
                }
            }
        });
        findViewById(R.id.btn_system_download_cache_directory).setOnClickListener(new View.OnClickListener() {
            @SuppressLint("LongLogTag")
            @Override
            public void onClick(View v) {
                if (hasExternalStorageWritePermission()) {
                    // 权限已经授予，可以进行相关操作
                    File downloadCacheDirectory = Environment.getDownloadCacheDirectory();
                    Log.i(TAG, "系统存储：Environment.getDownloadCacheDirectory()=" + downloadCacheDirectory.getAbsolutePath());
                    makeFile(downloadCacheDirectory.getAbsolutePath());
                } else {
                    // 权限未授予，需要向用户申请权限
                    requestExternalStorageWritePermission();
                }
            }
        });
    }
}
