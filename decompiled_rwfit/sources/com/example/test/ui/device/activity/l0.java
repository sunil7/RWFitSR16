package com.example.test.ui.device.activity;

import android.text.format.DateFormat;
import com.autonavi.aps.amapapi.config.Const;
import com.example.blesdk.bean.function.WomenHealthBean;
import com.example.test.presenter.device.n1;
import com.example.test.ui.XXBaseActivity;
import java.util.TimeZone;

/* loaded from: classes.dex */
public final class l0 implements a7.e, t6.d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WomenHealthActivity f7875a;

    public /* synthetic */ l0(WomenHealthActivity womenHealthActivity) {
        this.f7875a = womenHealthActivity;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // a7.e
    public void B() {
        int i3 = WomenHealthActivity.I;
        WomenHealthActivity womenHealthActivity = this.f7875a;
        n1 n1Var = (n1) womenHealthActivity.I0();
        WomenHealthBean data = womenHealthActivity.R0();
        n1Var.getClass();
        kotlin.jvm.internal.e.f(data, "data");
        n1Var.f7465b = data;
        ((XXBaseActivity) ((f7.c0) n1Var.f7255a)).V();
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 52);
            return;
        }
        x5.d c9 = x5.d.c();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "CmdHelper", "获取生理周期 " + data);
        int type = data.getType();
        char[] cArr = y5.b.f20001a;
        byte b3 = (byte) (type & 255);
        byte b10 = (byte) ((data.isOpen() ? 1 : 0) & 255);
        byte b11 = (byte) ((data.isMensOpen() ? 1 : 0) & 255);
        byte b12 = (byte) ((data.isOvulOpen() ? 1 : 0) & 255);
        byte b13 = (byte) ((data.isOvulHighOpen() ? 1 : 0) & 255);
        byte b14 = (byte) ((data.isOvulOverOpen() ? 1 : 0) & 255);
        byte rangeDays = (byte) (data.getRangeDays() & 255);
        byte mensDays = (byte) (data.getMensDays() & 255);
        byte[] r = y5.b.r(((TimeZone.getDefault().getRawOffset() + (TimeZone.getDefault().useDaylightTime() ? Const.L_WIFI_EXP : 0L)) / 1000) + data.getLastDays());
        c9.j((byte) 52, new byte[]{b3, b10, b11, b12, b13, b14, rangeDays, mensDays, r[3], r[2], r[1], r[0], (byte) (data.getRemindHour() & 255), (byte) (data.getRemindMin() & 255)});
    }

    @Override // t6.d
    public void h(int i3, int i10, int i11) {
        WomenHealthActivity context = this.f7875a;
        kotlin.jvm.internal.e.f(context, "context");
        if (!DateFormat.is24HourFormat(context)) {
            int i12 = i10 + 1;
            if (i3 == 1) {
                if (i12 < 12) {
                    i10 += 13;
                }
                i10 = i12;
            } else {
                if (i12 == 12) {
                    i10 = 0;
                }
                i10 = i12;
            }
        }
        int i13 = WomenHealthActivity.I;
        context.R0().setRemindHour(i10);
        context.R0().setRemindMin(i11);
        context.S0();
    }

    @Override // a7.e
    public void u0() {
        this.f7875a.onBackPressed();
    }

    @Override // t6.d
    public void y() {
    }
}
