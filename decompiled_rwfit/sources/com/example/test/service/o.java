package com.example.test.service;

import com.example.blesdk.bean.function.HrBoActualReminderBean;
import com.example.test.ui.model.EventBusBeans;

/* loaded from: classes.dex */
public final class o implements v5.i {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d0 f7737a;

    public o(d0 d0Var) {
        this.f7737a = d0Var;
    }

    @Override // u5.g
    public final void a(int i3) {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "DeviceMonitorService", android.support.v4.media.session.e.i(this.f7737a, "心率血氧实时提醒失败:", i3));
    }

    @Override // u5.g
    public final void c() {
    }

    @Override // u5.g
    public final void e(Object obj) {
        HrBoActualReminderBean hrBoActualReminderBean = (HrBoActualReminderBean) obj;
        if (hrBoActualReminderBean != null) {
            yh.d.b().e(new EventBusBeans.HrBoActualReminderEvent(hrBoActualReminderBean));
        }
    }
}
