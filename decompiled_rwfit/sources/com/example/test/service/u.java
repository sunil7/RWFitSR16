package com.example.test.service;

import android.util.Log;

/* loaded from: classes.dex */
public final class u implements u5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f7809a;

    public u(d0 d0Var) {
        this.f7809a = d0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceMonitorService", android.support.v4.media.session.e.i(this.f7809a, "音乐控制广播失败：", i3));
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        Integer num = (Integer) obj;
        if (num != null) {
            int intValue = num.intValue();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceMonitorService", android.support.v4.media.session.e.i(this.f7809a, "音乐控制广播成功:", intValue));
            h0 h0Var = g0.f7705a;
            h0Var.getClass();
            Log.e("qob", "sendKeyEvent " + intValue);
            if (System.currentTimeMillis() - h0Var.f7715f < 1100) {
                Log.e("qob", "下发时间少于 100ms不处理");
                return;
            }
            h0Var.f7715f = System.currentTimeMillis();
            if (intValue == 2) {
                h0Var.b(85);
                return;
            }
            if (intValue == 3) {
                h0Var.b(87);
                return;
            }
            if (intValue == 4) {
                h0Var.b(88);
            } else if (intValue == 6) {
                h0Var.d(intValue);
            } else if (intValue == 5) {
                h0Var.d(intValue);
            }
        }
    }
}
