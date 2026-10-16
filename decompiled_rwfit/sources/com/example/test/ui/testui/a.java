package com.example.test.ui.testui;

/* loaded from: classes.dex */
public final class a implements a7.e, t6.a {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BoReminderActivity f8255a;

    public /* synthetic */ a(BoReminderActivity boReminderActivity) {
        this.f8255a = boReminderActivity;
    }

    @Override // a7.e
    public void B() {
        int i3 = BoReminderActivity.G;
        BoReminderActivity boReminderActivity = this.f8255a;
        ((com.example.test.presenter.device.i) boReminderActivity.I0()).m(boReminderActivity.S0());
    }

    @Override // a7.e
    public void u0() {
        this.f8255a.onBackPressed();
    }

    @Override // t6.a
    public void v(String data) {
        kotlin.jvm.internal.e.f(data, "data");
        int i3 = BoReminderActivity.G;
        BoReminderActivity boReminderActivity = this.f8255a;
        boReminderActivity.S0().setRemindValue(Integer.parseInt(data));
        ((com.example.test.presenter.device.i) boReminderActivity.I0()).m(boReminderActivity.S0());
        boReminderActivity.R0();
    }
}
