package com.example.test.ui.device.activity;

import com.example.blesdk.bean.function.JLWomenHealthBean;
import com.example.test.presenter.device.m1;
import com.example.test.ui.XXBaseActivity;

/* loaded from: classes.dex */
public final class m0 implements a7.e, t6.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WomenHealthJLActivity f7877a;

    public /* synthetic */ m0(WomenHealthJLActivity womenHealthJLActivity) {
        this.f7877a = womenHealthJLActivity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a7.e
    public void B() {
        int i3 = WomenHealthJLActivity.K;
        WomenHealthJLActivity womenHealthJLActivity = this.f7877a;
        m1 m1Var = (m1) womenHealthJLActivity.I0();
        JLWomenHealthBean data = womenHealthJLActivity.R0();
        m1Var.getClass();
        kotlin.jvm.internal.e.f(data, "data");
        m1Var.f7462b = data;
        ((XXBaseActivity) ((f7.c0) m1Var.f7255a)).V();
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -46);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "CmdHelper", "获取生理周期 " + data);
        boolean isOpen = data.isOpen();
        char[] cArr = y5.b.f20001a;
        b3.g((byte) -46, new byte[]{2, 26, 0, (byte) ((isOpen ? 1 : 0) & 255), (byte) (data.getRemindHour() & 255), (byte) (data.getRemindMin() & 255), (byte) (data.getPeriodDays() & 255), (byte) (data.getOvulateDays() & 255), (byte) (data.getLastPeriodY() & 255), (byte) (data.getLastPeriodM() & 255), (byte) (data.getLastPeriodD() & 255), (byte) (data.getPeriodDuration() & 255), (byte) (data.getRangeDuration() & 255)}, new boolean[0]);
    }

    @Override // a7.e
    public void u0() {
        this.f7877a.onBackPressed();
    }

    @Override // t6.a
    public void v(String data) {
        kotlin.jvm.internal.e.f(data, "data");
        int i3 = WomenHealthJLActivity.K;
        WomenHealthJLActivity womenHealthJLActivity = this.f7877a;
        womenHealthJLActivity.R0().setPeriodDays(Integer.parseInt(data));
        womenHealthJLActivity.S0();
    }
}
