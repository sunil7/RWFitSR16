package com.autonavi.amap.mapcore.animation;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;

/* loaded from: classes.dex */
public class GLRotateAnimation extends GLAnimation {
    private float mFromDegrees;
    private float mToDegrees;

    public GLRotateAnimation(float f2, float f10, float f11, float f12, float f13) {
        this.mFromDegrees = f2;
        this.mToDegrees = f10;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void applyTransformation(float f2, GLTransformation gLTransformation) {
        float f10 = this.mFromDegrees;
        gLTransformation.rotate = l0.a(this.mToDegrees, f10, f2, f10);
    }
}
