package com.example.test.ui.testui;

import com.example.test.ui.model.EventBusBeans;

/* loaded from: classes.dex */
public final class h implements n2.j {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TMainRingActivity f8280a;

    public h(TMainRingActivity tMainRingActivity) {
        this.f8280a = tMainRingActivity;
    }

    @Override // n2.j
    public final void a(int i3) {
    }

    @Override // n2.j
    public final void b(int i3) {
        r5.a.h(i3, "onPageSelected ", "qob");
        if (i3 > 0) {
            TMainRingActivity tMainRingActivity = this.f8280a;
            if (i3 < tMainRingActivity.S0().c() - 1) {
                tMainRingActivity.onChangeBackToFrontEvent(new EventBusBeans.ChangeBackToFrontEvent());
            }
        }
    }

    @Override // n2.j
    public final void d(float f2, int i3) {
    }
}
