package com.example.test.service;

import android.util.Log;
import com.example.blesdk.bean.function.SupportMenuBean;
import com.example.test.ui.model.EventBusBeans;
import com.google.android.gms.internal.mlkit_vision_barcode.d2;

/* loaded from: classes.dex */
public final class p1 implements v5.t {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ u1 f7747a;

    public p1(u1 u1Var) {
        this.f7747a = u1Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        this.f7747a.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "获取功能表失败，原因:" + i3);
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        SupportMenuBean supportMenuBean = (SupportMenuBean) obj;
        this.f7747a.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", "获取功能表成功");
        if (supportMenuBean != null) {
            this.f7747a.getClass();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "SyncService", String.valueOf(supportMenuBean));
            Log.e("qob", "supportCallback getLocalSupport");
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            if (kVar != null) {
                kVar.F(supportMenuBean);
            }
            Object obj2 = com.example.test.utils.m.f8734b;
            com.example.test.utils.m a3 = d2.a();
            a3.getClass();
            a3.f8735a = supportMenuBean;
            yh.d.b().e(new EventBusBeans.DeviceSupportEvent(supportMenuBean));
        }
    }
}
