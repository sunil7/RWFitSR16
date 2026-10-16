package com.otaliastudios.cameraview.gesture;

import android.view.ScaleGestureDetector;

/* loaded from: classes2.dex */
public final class c extends ScaleGestureDetector.SimpleOnScaleGestureListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d f11602a;

    public c(d dVar) {
        this.f11602a = dVar;
    }

    @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
    public final boolean onScale(ScaleGestureDetector scaleGestureDetector) {
        d dVar = this.f11602a;
        dVar.e = true;
        dVar.f11604f = (scaleGestureDetector.getScaleFactor() - 1.0f) * 2.0f;
        return true;
    }
}
