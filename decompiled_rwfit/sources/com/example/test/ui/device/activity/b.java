package com.example.test.ui.device.activity;

import com.example.test.ui.model.EventBusBeans;

/* loaded from: classes.dex */
public final class b implements a7.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AlarmAddActivity f7846a;

    public b(AlarmAddActivity alarmAddActivity) {
        this.f7846a = alarmAddActivity;
    }

    @Override // a7.e
    public final void B() {
        int i3 = AlarmAddActivity.N;
        AlarmAddActivity alarmAddActivity = this.f7846a;
        alarmAddActivity.R0().setAdd(false);
        yh.d.b().e(new EventBusBeans.AlarmEvent(((Number) alarmAddActivity.E.getValue()).intValue(), ((Boolean) alarmAddActivity.G.getValue()).booleanValue(), alarmAddActivity.R0()));
        alarmAddActivity.finish();
    }

    @Override // a7.e
    public final void u0() {
        this.f7846a.onBackPressed();
    }
}
