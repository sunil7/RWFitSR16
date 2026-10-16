package com.otaliastudios.cameraview.gesture;

import android.content.res.TypedArray;
import com.otaliastudios.cameraview.R$styleable;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final int f11598a;

    /* renamed from: b, reason: collision with root package name */
    public final int f11599b;

    /* renamed from: c, reason: collision with root package name */
    public final int f11600c;

    /* renamed from: d, reason: collision with root package name */
    public final int f11601d;
    public final int e;

    public b(TypedArray typedArray) {
        this.f11598a = typedArray.getInteger(R$styleable.CameraView_cameraGestureTap, GestureAction.DEFAULT_TAP.value());
        this.f11599b = typedArray.getInteger(R$styleable.CameraView_cameraGestureLongTap, GestureAction.DEFAULT_LONG_TAP.value());
        this.f11600c = typedArray.getInteger(R$styleable.CameraView_cameraGesturePinch, GestureAction.DEFAULT_PINCH.value());
        this.f11601d = typedArray.getInteger(R$styleable.CameraView_cameraGestureScrollHorizontal, GestureAction.DEFAULT_SCROLL_HORIZONTAL.value());
        this.e = typedArray.getInteger(R$styleable.CameraView_cameraGestureScrollVertical, GestureAction.DEFAULT_SCROLL_VERTICAL.value());
    }
}
