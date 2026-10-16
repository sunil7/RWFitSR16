package com.example.test.service;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.util.Log;
import com.example.database.table.Devices;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.example.test.ui.device.activity.TakePhotoActivity;
import com.example.test.ui.model.EventBusBeans;

/* loaded from: classes.dex */
public final class a0 implements v5.c0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f7650a;

    public a0(d0 d0Var) {
        this.f7650a = d0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceMonitorService", android.support.v4.media.session.e.i(this.f7650a, "拍照监控失败：", i3));
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        Devices c9;
        Activity c10;
        Integer num = (Integer) obj;
        Log.e("qob", "takePhotoCallback onResult " + num);
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar == null || (c9 = kVar.c()) == null) {
            return;
        }
        this.f7650a.getClass();
        XXApplication xXApplication = XXApplication.f7400h;
        boolean z5 = com.google.android.gms.internal.mlkit_vision_barcode.j1.a().f7401a;
        Activity c11 = com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c();
        ComponentName componentName = c11 != null ? c11.getComponentName() : null;
        Activity c12 = com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c();
        Boolean valueOf = c12 != null ? Boolean.valueOf(c12.isDestroyed()) : null;
        Activity c13 = com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceMonitorService", "Application " + z5 + " getCurrentActivity " + componentName + " status isDestroyed " + valueOf + " isFinish " + (c13 != null ? Boolean.valueOf(c13.isFinishing()) : null));
        if (!com.google.android.gms.internal.mlkit_vision_barcode.j1.a().f7401a) {
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceMonitorService", "APP在后台不处理");
            return;
        }
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
        if (kVar2 != null) {
            if (!kVar2.J(c9.getMacAddress())) {
                if (num == null || num.intValue() <= 0) {
                    return;
                }
                com.example.baselibrary.utils.d.a(R$string.str_please_open_carmer);
                return;
            }
            if (num != null && num.intValue() == 0) {
                Log.e("qob", "takePhotoCallback onResult 0 关闭相机 ");
                yh.d.b().e(new EventBusBeans.TakePhotoEvent(0));
                return;
            }
            if (num != null && num.intValue() == 1) {
                Activity c14 = com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c();
                if (c14 == null || c14.getClass().getName().equals(TakePhotoActivity.class.getName())) {
                    return;
                }
                Log.e("qob", "takePhotoCallback onResult 1 打开相机界面 ");
                c14.startActivity(new Intent(c14, (Class<?>) TakePhotoActivity.class));
                return;
            }
            if (num == null || num.intValue() != 2 || (c10 = com.google.android.gms.internal.mlkit_vision_barcode.j1.a().c()) == null) {
                return;
            }
            if (c10.getClass().getName().equals(TakePhotoActivity.class.getName())) {
                yh.d.b().e(new EventBusBeans.TakePhotoEvent(2));
            } else {
                c10.startActivity(new Intent(c10, (Class<?>) TakePhotoActivity.class));
            }
        }
    }
}
