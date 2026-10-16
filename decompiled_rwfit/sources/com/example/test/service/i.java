package com.example.test.service;

import android.os.Build;
import android.telecom.TelecomManager;
import android.telephony.TelephonyManager;
import com.example.test.XXApplication;
import java.lang.reflect.Method;

/* loaded from: classes.dex */
public final class i implements u5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f7719a;

    public i(d0 d0Var) {
        this.f7719a = d0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceMonitorService", android.support.v4.media.session.e.i(this.f7719a, "来电操作广播失败：", i3));
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        Integer num = (Integer) obj;
        if (num != null) {
            d0 d0Var = this.f7719a;
            int intValue = num.intValue();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceMonitorService", android.support.v4.media.session.e.i(d0Var, "来电操作广播成功:", intValue));
            if (intValue != 2) {
                return;
            }
            synchronized (q0.a()) {
                if (Build.VERSION.SDK_INT >= 28) {
                    try {
                        XXApplication xXApplication = XXApplication.f7400h;
                        TelecomManager telecomManager = (TelecomManager) com.google.android.gms.internal.mlkit_vision_barcode.j1.a().getSystemService("telecom");
                        if (telecomManager != null) {
                            if (a1.g.a(com.google.android.gms.internal.mlkit_vision_barcode.j1.a(), "android.permission.ANSWER_PHONE_CALLS") != 0) {
                                return;
                            } else {
                                telecomManager.endCall();
                            }
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    return;
                }
                try {
                    XXApplication xXApplication2 = XXApplication.f7400h;
                    TelephonyManager telephonyManager = (TelephonyManager) com.google.android.gms.internal.mlkit_vision_barcode.j1.a().getSystemService("phone");
                    Method declaredMethod = Class.forName(telephonyManager.getClass().getName()).getDeclaredMethod("getITelephony", null);
                    declaredMethod.setAccessible(true);
                    Object invoke = declaredMethod.invoke(telephonyManager, null);
                    Class.forName(invoke.getClass().getName()).getDeclaredMethod("endCall", null).invoke(invoke, null);
                } catch (Exception e10) {
                    e10.printStackTrace();
                }
                return;
            }
        }
    }
}
