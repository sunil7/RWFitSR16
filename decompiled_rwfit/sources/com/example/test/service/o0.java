package com.example.test.service;

import com.example.blesdk.bean.function.OTAStatusBean;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class o0 implements u5.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ p0 f7738a;

    public o0(p0 p0Var) {
        this.f7738a = p0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        p0 p0Var = this.f7738a;
        p0Var.getClass();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "OTAService", "获取OTA状态失败" + i3);
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
        OTAStatusBean oTAStatusBean = (OTAStatusBean) obj;
        if (oTAStatusBean != null) {
            p0 p0Var = this.f7738a;
            p0Var.getClass();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "OTAService", "OTA状态信息 " + oTAStatusBean);
            oTAStatusBean.getOtaStatus();
            if (!oTAStatusBean.isOtaComplete()) {
                Object obj2 = p0.f7741g;
                Iterator it = ((List) p0Var.f7744c.getValue()).iterator();
                if (it.hasNext()) {
                    throw android.support.v4.media.session.e.d(it);
                }
            }
            p0Var.h(false);
        }
    }
}
