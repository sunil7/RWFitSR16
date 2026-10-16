package com.otaliastudios.cameraview.gesture;

import android.view.GestureDetector;
import android.view.MotionEvent;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.otaliastudios.cameraview.CameraView;
import ef.i;

/* loaded from: classes2.dex */
public final class e extends GestureDetector.SimpleOnGestureListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ i f11605a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ f f11606b;

    public e(f fVar, i iVar) {
        this.f11606b = fVar;
        this.f11605a = iVar;
    }

    @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
    public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f10) {
        f.f11607g.b(1, "onScroll:", l0.m("distanceX=", f2), l0.m("distanceY=", f10));
        boolean z5 = false;
        if (motionEvent == null || motionEvent2 == null) {
            return false;
        }
        float x10 = motionEvent.getX();
        f fVar = this.f11606b;
        if (x10 != fVar.f11597c[0].x || motionEvent.getY() != fVar.f11597c[0].y) {
            boolean z6 = Math.abs(f2) >= Math.abs(f10);
            fVar.f11596b = z6 ? Gesture.SCROLL_HORIZONTAL : Gesture.SCROLL_VERTICAL;
            fVar.f11597c[0].set(motionEvent.getX(), motionEvent.getY());
            z5 = z6;
        } else if (fVar.f11596b == Gesture.SCROLL_HORIZONTAL) {
            z5 = true;
        }
        fVar.f11597c[1].set(motionEvent2.getX(), motionEvent2.getY());
        i iVar = this.f11605a;
        fVar.f11609f = z5 ? f2 / ((CameraView) iVar.f12630c).getWidth() : f10 / ((CameraView) iVar.f12630c).getHeight();
        float f11 = fVar.f11609f;
        if (z5) {
            f11 = -f11;
        }
        fVar.f11609f = f11;
        fVar.e = true;
        return true;
    }
}
