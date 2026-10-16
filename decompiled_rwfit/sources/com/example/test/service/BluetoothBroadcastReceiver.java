package com.example.test.service;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import com.example.test.ui.model.EventBusBeans;
import java.util.Objects;

/* loaded from: classes.dex */
public class BluetoothBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f7640a = 0;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        Log.e("qob", "BluetoothBroadcastReceiver onReceive " + intent.getAction());
        String action = intent.getAction();
        Objects.requireNonNull(action);
        if ("android.bluetooth.adapter.action.STATE_CHANGED".equals(action)) {
            int intExtra = intent.getIntExtra("android.bluetooth.adapter.extra.STATE", 0);
            if (intExtra != 10) {
                if (intExtra != 12) {
                    return;
                }
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ConnectManage", "onReceive: 蓝牙打开开始重连");
                e.h().n();
                return;
            }
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "ConnectManage", "onReceive: 蓝牙关闭");
            e h4 = e.h();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceConnectService", "蓝牙关闭，强制重置连接状态 isConnecting=" + h4.f7683b + " isDeviceConnected=" + h4.i() + " isAutoConnect=" + h4.f7682a);
            h4.f7683b = false;
            h4.f7689i = false;
            h4.f7686f.removeMessages(101);
            s5.a aVar = h4.e;
            if (aVar != null) {
                aVar.f18213d = 0;
            }
            r5.b.k().e(false);
            yh.d.b().e(new EventBusBeans.DeviceStatusEvent(0));
        }
    }
}
