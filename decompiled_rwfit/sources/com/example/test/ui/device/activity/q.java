package com.example.test.ui.device.activity;

import com.example.test.ui.model.EventBusBeans;
import f6.s0;

/* loaded from: classes.dex */
public final class q implements a7.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MensRemindModelActivity f7885a;

    public q(MensRemindModelActivity mensRemindModelActivity) {
        this.f7885a = mensRemindModelActivity;
    }

    @Override // a7.e
    public final void B() {
        int i3 = MensRemindModelActivity.I;
        MensRemindModelActivity mensRemindModelActivity = this.f7885a;
        boolean itemOpen = ((s0) mensRemindModelActivity.f7247z.getValue()).f13291b.getItemOpen();
        eh.b bVar = mensRemindModelActivity.f7247z;
        yh.d.b().e(new EventBusBeans.WomenHealthRemindEvent(itemOpen, ((s0) bVar.getValue()).e.getItemOpen(), ((s0) bVar.getValue()).f13293d.getItemOpen(), ((s0) bVar.getValue()).f13292c.getItemOpen()));
        mensRemindModelActivity.onBackPressed();
    }

    @Override // a7.e
    public final void u0() {
        this.f7885a.onBackPressed();
    }
}
