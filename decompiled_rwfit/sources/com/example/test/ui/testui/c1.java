package com.example.test.ui.testui;

import com.example.test.ui.model.EventBusBeans;

/* loaded from: classes.dex */
public final class c1 implements a7.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TringAlarmAddActivity f8267a;

    public c1(TringAlarmAddActivity tringAlarmAddActivity) {
        this.f8267a = tringAlarmAddActivity;
    }

    @Override // a7.e
    public final void B() {
        int i3 = TringAlarmAddActivity.N;
        TringAlarmAddActivity tringAlarmAddActivity = this.f8267a;
        tringAlarmAddActivity.R0().setAdd(false);
        yh.d.b().e(new EventBusBeans.AlarmEvent(((Number) tringAlarmAddActivity.E.getValue()).intValue(), ((Boolean) tringAlarmAddActivity.G.getValue()).booleanValue(), tringAlarmAddActivity.R0()));
        tringAlarmAddActivity.finish();
    }

    @Override // a7.e
    public final void u0() {
        this.f8267a.onBackPressed();
    }
}
