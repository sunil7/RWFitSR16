package com.google.android.material.timepicker;

import android.view.GestureDetector;
import android.view.MotionEvent;

/* loaded from: classes.dex */
public final class k extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TimePickerView f10984a;

    public k(TimePickerView timePickerView) {
        this.f10984a = timePickerView;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
    public final boolean onDoubleTap(MotionEvent motionEvent) {
        boolean onDoubleTap = super.onDoubleTap(motionEvent);
        int i3 = TimePickerView.f10975u;
        this.f10984a.getClass();
        return onDoubleTap;
    }
}
