package com.autonavi.amap.mapcore.animation;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;

/* loaded from: classes.dex */
public class GLAlphaAnimation extends GLAnimation {
    public float mCurAlpha = 0.0f;
    public float mFromAlpha;
    public float mToAlpha;

    public GLAlphaAnimation(float f2, float f10) {
        this.mFromAlpha = f2;
        this.mToAlpha = f10;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void applyTransformation(float f2, GLTransformation gLTransformation) {
        float f10 = this.mFromAlpha;
        float a3 = l0.a(this.mToAlpha, f10, f2, f10);
        this.mCurAlpha = a3;
        gLTransformation.alpha = a3;
    }
}
