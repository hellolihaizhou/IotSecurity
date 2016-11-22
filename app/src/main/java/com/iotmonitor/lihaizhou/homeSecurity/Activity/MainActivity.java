package com.iotmonitor.lihaizhou.homeSecurity.Activity;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.iotmonitor.lihaizhou.homeSecurity.R;
import com.iotmonitor.lihaizhou.homeSecurity.Service.QueryService;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private static boolean isServiceConneceed = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupView();
        bindService();
    }

    private void setupView()
    {

    }

    private void bindService()
    {
        Intent intent = new Intent(this,QueryService.class);
        bindService(intent,serviceConnection, Context.BIND_AUTO_CREATE);
    }

    /*if need stop service,call this api*/
    private void unbindService()
    {
        if(isServiceConneceed = true)
        {
            Log.d(TAG,"unbindService called");
            unbindService(serviceConnection);
            isServiceConneceed = false;
        }
    }

    private ServiceConnection serviceConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.d(TAG,"onServiceConnected called");
            QueryService.IotMonitorBinder iotMonitorBinder = (QueryService.IotMonitorBinder)iBinder;
            QueryService queryService = iotMonitorBinder.getQueryService();//call QueryService's api by queryservice
            isServiceConneceed = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            Log.d(TAG,"onServiceDisconnected called");
        }
    };

    @Override
    protected void onPause() {
        super.onPause();
    }

    /*for map end*/
    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}