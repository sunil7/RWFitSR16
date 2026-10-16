package com.autonavi.amap.mapcore.animation;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;

/* loaded from: classes.dex */
public class GLScaleAnimation extends GLAnimation {
    private float mFromX;
    private float mFromY;
    private float mPivotX = 0.0f;
    private float mPivotY = 0.0f;
    private float mToX;
    private float mToY;

    public GLScaleAnimation(float f2, float f10, float f11, float f12) {
        this.mFromX = f2;
        this.mToX = f10;
        this.mFromY = f11;
        this.mToY = f12;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void applyTransformation(float f2, GLTransformation gLTransformation) {
        float f10 = this.mFromX;
        float a3 = (f10 == 1.0f && this.mToX == 1.0f) ? 1.0f : l0.a(this.mToX, f10, f2, f10);
        float f11 = this.mFromY;
        float a10 = (f11 == 1.0f && this.mToY == 1.0f) ? 1.0f : l0.a(this.mToY, f11, f2, f11);
        if (this.mPivotX == 0.0f && this.mPivotY == 0.0f) {
            gLTransformation.scaleX = a3;
            gLTransformation.scaleY = a10;
        } else {
            gLTransformation.scaleX = a3;
            gLTransformation.scaleY = a10;
        }
    }
}
