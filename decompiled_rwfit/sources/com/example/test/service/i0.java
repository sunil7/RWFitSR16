package com.example.test.service;

import com.example.blesdk.bean.function.FirmVersionBean;
import com.example.database.table.Devices;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class i0 implements v5.h {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p0 f7720a;

    public i0(p0 p0Var) {
        this.f7720a = p0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        p0 p0Var = this.f7720a;
        p0Var.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "OTAService", "获取固件版本错误" + i3);
        Iterator it = ((List) p0Var.f7744c.getValue()).iterator();
        if (it.hasNext()) {
            throw android.support.v4.media.session.e.d(it);
        }
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        Devices c9;
        FirmVersionBean firmVersionBean = (FirmVersionBean) obj;
        if (firmVersionBean != null) {
            p0 p0Var = this.f7720a;
            p0Var.getClass();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "OTAService", "获取固件版本成功 " + firmVersionBean);
            p0Var.d().setFromVersion(firmVersionBean.getDeviceNo());
            kotlin.jvm.internal.e.e(p0Var.d().getFromVersion(), "getFromVersion(...)");
            Iterator it = ((List) p0Var.f7744c.getValue()).iterator();
            if (it.hasNext()) {
                throw android.support.v4.media.session.e.d(it);
            }
            p0Var.e();
            yh.d.b().e(firmVersionBean);
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            if (kVar == null || (c9 = kVar.c()) == null) {
                return;
            }
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "OTAService", com.google.android.gms.internal.mlkit_vision_barcode.l0.n("固件版本信息：", firmVersionBean.getDeviceNo()));
            c9.setDeviceVer(firmVersionBean.getDeviceNo());
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
            if (kVar2 != null) {
                kVar2.a(c9);
            }
        }
    }
}
