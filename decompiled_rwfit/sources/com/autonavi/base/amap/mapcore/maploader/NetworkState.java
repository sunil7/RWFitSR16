package com.autonavi.base.amap.mapcore.maploader;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.lang.ref.WeakReference;

/* loaded from: classes.dex */
public class NetworkState {
    private NetworkChangeListener mNetworkListener;
    private boolean isNetReceiverRegistered = false;
    private MyBroadcastReceiver netChangeReceiver = null;

    public static class MyBroadcastReceiver extends BroadcastReceiver {
        WeakReference<NetworkChangeListener> reference;

        public MyBroadcastReceiver(NetworkChangeListener networkChangeListener) {
            this.reference = null;
            this.reference = new WeakReference<>(networkChangeListener);
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            WeakReference<NetworkChangeListener> weakReference = this.reference;
            if (weakReference == null || weakReference.get() == null) {
                return;
            }
            this.reference.get().networkStateChanged(context);
        }
    }

    public interface NetworkChangeListener {
        void networkStateChanged(Context context);
    }

    public static NetworkInfo getActiveNetworkInfo(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            if (connectivityManager == null) {
                return null;
            }
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected()) {
                return activeNetworkInfo;
            }
            NetworkInfo[] allNetworkInfo = connectivityManager.getAllNetworkInfo();
            if (allNetworkInfo == null) {
                return null;
            }
            for (int i3 = 0; i3 < allNetworkInfo.length; i3++) {
                NetworkInfo networkInfo = allNetworkInfo[i3];
                if (networkInfo != null && networkInfo.isConnected()) {
                    return allNetworkInfo[i3];
                }
            }
            return activeNetworkInfo;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isNetworkConnected(Context context) {
        NetworkInfo activeNetworkInfo = getActiveNetworkInfo(context);
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public void registerNetChangeReceiver(Context context, boolean z5) {
        MyBroadcastReceiver myBroadcastReceiver;
        if (z5) {
            if (!this.isNetReceiverRegistered) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
                if (this.netChangeReceiver == null) {
                    this.netChangeReceiver = new MyBroadcastReceiver(this.mNetworkListener);
                }
                context.registerReceiver(this.netChangeReceiver, intentFilter);
            }
        } else if (this.isNetReceiverRegistered && (myBroadcastReceiver = this.netChangeReceiver) != null) {
            context.unregisterReceiver(myBroadcastReceiver);
            this.netChangeReceiver = null;
        }
        this.isNetReceiverRegistered = z5;
    }

    public void setNetworkListener(NetworkChangeListener networkChangeListener) {
        this.mNetworkListener = networkChangeListener;
    }
}
