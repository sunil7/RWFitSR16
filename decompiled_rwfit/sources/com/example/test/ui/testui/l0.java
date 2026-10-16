package com.example.test.ui.testui;

import com.example.database.table.User;
import com.example.test.ui.model.EventBusBeans;

/* loaded from: classes.dex */
public final class l0 implements t6.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TRingPCycleSettingsActivity f8289a;

    public l0(TRingPCycleSettingsActivity tRingPCycleSettingsActivity) {
        this.f8289a = tRingPCycleSettingsActivity;
    }

    @Override // t6.a
    public final void v(String data) {
        kotlin.jvm.internal.e.f(data, "data");
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar != null) {
            int parseInt = Integer.parseInt(data);
            User d5 = kVar.d();
            if (d5 != null) {
                kVar.M(Integer.valueOf(parseInt), android.support.v4.media.session.e.l(d5.getUserId(), "menstrual_days"));
            }
        }
        yh.d.b().e(new EventBusBeans.WomenHealthRemindSettingEvent());
        TRingPCycleSettingsActivity tRingPCycleSettingsActivity = this.f8289a;
        int i3 = TRingPCycleSettingsActivity.I;
        tRingPCycleSettingsActivity.R0();
    }
}
