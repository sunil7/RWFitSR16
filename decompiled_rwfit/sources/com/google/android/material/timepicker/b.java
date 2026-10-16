package com.google.android.material.timepicker;

import android.view.ViewTreeObserver;

/* loaded from: classes.dex */
public final class b implements ViewTreeObserver.OnPreDrawListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ClockFaceView f10979a;

    public b(ClockFaceView clockFaceView) {
        this.f10979a = clockFaceView;
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public final boolean onPreDraw() {
        ClockFaceView clockFaceView = this.f10979a;
        if (!clockFaceView.isShown()) {
            return true;
        }
        clockFaceView.getViewTreeObserver().removeOnPreDrawListener(this);
        int height = ((clockFaceView.getHeight() / 2) - clockFaceView.f10954v.f10960b) - clockFaceView.C;
        if (height != clockFaceView.f10969t) {
            clockFaceView.f10969t = height;
            clockFaceView.p();
            int i3 = clockFaceView.f10969t;
            ClockHandView clockHandView = clockFaceView.f10954v;
            clockHandView.f10967j = i3;
            clockHandView.invalidate();
        }
        return true;
    }
}
