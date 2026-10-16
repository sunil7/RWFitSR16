package com.example.test;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.example.blesdk.bean.function.SupportMenuBean;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.utils.m;
import com.google.android.gms.internal.mlkit_vision_barcode.d2;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import kotlin.jvm.internal.e;
import x5.c;
import yh.d;

/* loaded from: classes.dex */
public final class a implements Application.ActivityLifecycleCallbacks {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ XXApplication f7407a;

    public a(XXApplication xXApplication) {
        this.f7407a = xXApplication;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityCreated(Activity activity, Bundle bundle) {
        e.f(activity, "activity");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityDestroyed(Activity activity) {
        e.f(activity, "activity");
        this.f7407a.f7403c.remove(activity);
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityPaused(Activity activity) {
        e.f(activity, "activity");
        this.f7407a.f7402b = null;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityResumed(Activity activity) {
        e.f(activity, "activity");
        XXApplication xXApplication = this.f7407a;
        xXApplication.f7402b = activity;
        xXApplication.f7401a = true;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivitySaveInstanceState(Activity activity, Bundle outState) {
        e.f(activity, "activity");
        e.f(outState, "outState");
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStarted(Activity activity) {
        e.f(activity, "activity");
        XXApplication xXApplication = this.f7407a;
        xXApplication.f7403c.add(activity);
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "BaseApplication", l0.j(xXApplication.f7404d, "onActivityStarted 后台切换到前台1111"));
        if (xXApplication.f7404d == 0) {
            xXApplication.f7401a = true;
            xXApplication.e = true;
            d.b().e(new EventBusBeans.ChangeBackToFrontEvent());
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "BaseApplication", "APP在前台" + this + " isJLDeviceLoginOk");
            if (com.example.test.service.e.h().f7689i) {
                Object obj = m.f8734b;
                SupportMenuBean supportMenuBean = d2.a().f8735a;
                boolean isAppFrontAndBack = supportMenuBean != null ? supportMenuBean.isAppFrontAndBack() : false;
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "BaseApplication", r5.a.d("APP进入前台 开始切换设备前后台支持", isAppFrontAndBack));
                if (isAppFrontAndBack) {
                    if (r5.b.k().f18054c) {
                        c b3 = c.b();
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "CmdHelper", "app前后台切换命令");
                        char[] cArr = y5.b.f20001a;
                        b3.g((byte) 64, new byte[]{6, 18, 0, (byte) 1}, new boolean[0]);
                    } else {
                        x5.b.I0().F0((byte) 64);
                    }
                }
            } else {
                com.example.test.service.e.h().n();
                if (!r5.b.k().f18054c) {
                    x5.b.I0().F0((byte) 72);
                } else if (!y5.d.f20005b) {
                    x5.d c9 = x5.d.c();
                    char[] cArr2 = y5.b.f20001a;
                    c9.j((byte) 72, new byte[]{(byte) 1});
                }
            }
        }
        xXApplication.f7404d++;
    }

    @Override // android.app.Application.ActivityLifecycleCallbacks
    public final void onActivityStopped(Activity activity) {
        e.f(activity, "activity");
        XXApplication xXApplication = this.f7407a;
        int i3 = xXApplication.f7404d - 1;
        xXApplication.f7404d = i3;
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "BaseApplication", l0.j(i3, "onActivityStopped 前台切换到后台"));
        if (xXApplication.f7404d == 0) {
            xXApplication.f7401a = false;
            Object obj = m.f8734b;
            SupportMenuBean supportMenuBean = d2.a().f8735a;
            boolean isAppFrontAndBack = supportMenuBean != null ? supportMenuBean.isAppFrontAndBack() : false;
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "BaseApplication", r5.a.d("APP进入后台 开始切换设备前后台支持", isAppFrontAndBack));
            if (isAppFrontAndBack && com.example.test.service.e.h().f7689i) {
                if (!r5.b.k().f18054c) {
                    x5.b.I0().F0((byte) 64);
                    return;
                }
                c b3 = c.b();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "CmdHelper", "app前后台切换命令");
                char[] cArr = y5.b.f20001a;
                b3.g((byte) 64, new byte[]{6, 18, 0, (byte) 2}, new boolean[0]);
            }
        }
    }
}
