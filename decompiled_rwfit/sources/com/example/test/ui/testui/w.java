package com.example.test.ui.testui;

import android.content.Intent;

/* loaded from: classes.dex */
public final class w implements u6.i, a7.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TRingFamilyActivity f8322a;

    public /* synthetic */ w(TRingFamilyActivity tRingFamilyActivity) {
        this.f8322a = tRingFamilyActivity;
    }

    @Override // a7.e
    public void B() {
        int i3 = TRingFamilyActivity.J;
        com.example.test.presenter.main.l0 l0Var = (com.example.test.presenter.main.l0) this.f8322a.I0();
        kotlin.jvm.internal.e.c(l0Var);
        TRingFamilyActivity tRingFamilyActivity = (TRingFamilyActivity) ((g7.n) l0Var.f7255a);
        tRingFamilyActivity.getClass();
        tRingFamilyActivity.startActivity(new Intent(tRingFamilyActivity, (Class<?>) TRingFamilyAddFriendActivity.class));
    }

    @Override // a7.e
    public void u0() {
        this.f8322a.onBackPressed();
    }
}
