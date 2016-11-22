package com.iotmonitor.lihaizhou.homeSecurity.Service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
/**
 * Created by lihaizhou on 2016/11/16 0016.
 */
public class  QueryService extends Service{
    private static final String TAG = "QueryService";

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d(TAG, "onStartCommand");
        return super.onStartCommand(intent,flags,startId);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        Log.d(TAG, "onCreate called");
    }

    public class IotMonitorBinder extends Binder
    {
        public QueryService getQueryService(){
            return QueryService.this;
        }
    }
    @Nullable

    @Override
    public IBinder onBind(Intent intent) {
        return new IotMonitorBinder();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}