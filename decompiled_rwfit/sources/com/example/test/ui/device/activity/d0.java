package com.example.test.ui.device.activity;

import com.example.test.R$string;
import com.example.test.ui.model.EventBusBeans;
import f6.p1;

/* loaded from: classes.dex */
public final class d0 implements a7.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScheduleAddActivity f7852a;

    public d0(ScheduleAddActivity scheduleAddActivity) {
        this.f7852a = scheduleAddActivity;
    }

    @Override // a7.e
    public final void B() {
        int i3 = ScheduleAddActivity.L;
        ScheduleAddActivity scheduleAddActivity = this.f7852a;
        String scheduleTitle = scheduleAddActivity.S0().getScheduleTitle();
        if (scheduleTitle == null || scheduleTitle.length() == 0) {
            com.example.baselibrary.utils.d.a(R$string.str_input_schedule_title);
            return;
        }
        scheduleAddActivity.S0().setAdd(false);
        scheduleAddActivity.S0().setScheduleMsg(((p1) scheduleAddActivity.f7247z.getValue()).f13222b.getText().toString());
        yh.d.b().e(new EventBusBeans.ScheduleEvent(((Number) scheduleAddActivity.G.getValue()).intValue(), ((Boolean) scheduleAddActivity.I.getValue()).booleanValue(), scheduleAddActivity.S0()));
        scheduleAddActivity.finish();
    }

    @Override // a7.e
    public final void u0() {
        this.f7852a.onBackPressed();
    }
}
