package com.example.test.service;

import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.example.blesdk.bean.function.BlueToothBean;
import com.example.test.XXApplication;

/* loaded from: classes.dex */
public class BTBroadcastReceiver extends BroadcastReceiver {

    /* renamed from: a, reason: collision with root package name */
    public BlueToothBean f7639a;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        BlueToothBean blueToothBean;
        if (intent != null) {
            if (!"android.bluetooth.device.action.FOUND".equals(intent.getAction())) {
                if (!"android.bluetooth.adapter.action.DISCOVERY_STARTED".equals(intent.getAction()) && "android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(intent.getAction())) {
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "BTBroadcastReceiver", "扫描经典蓝牙结束");
                    XXApplication xXApplication = XXApplication.f7400h;
                    com.google.android.gms.internal.mlkit_vision_barcode.j1.a();
                    com.google.android.gms.internal.mlkit_vision_barcode.j1.a().unregisterReceiver(this);
                    return;
                }
                return;
            }
            if (this.f7639a == null) {
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar != null) {
                    this.f7639a = kVar.e();
                }
            }
            BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
            if (bluetoothDevice == null || (blueToothBean = this.f7639a) == null || !blueToothBean.getMac().equals(bluetoothDevice.getAddress())) {
                return;
            }
            if (y5.d.e(this.f7639a.getMac())) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "BTBroadcastReceiver", "设备已被绑定 " + this.f7639a.getMac() + " name = " + this.f7639a.getName());
                return;
            }
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "BTBroadcastReceiver", "发起绑定 " + this.f7639a.getMac() + " name = " + this.f7639a.getName());
            y5.d.c(1, this.f7639a.getMac());
            XXApplication xXApplication2 = XXApplication.f7400h;
            com.google.android.gms.internal.mlkit_vision_barcode.j1.a();
            com.google.android.gms.internal.mlkit_vision_barcode.j1.a().unregisterReceiver(this);
        }
    }
}
