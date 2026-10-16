package com.autonavi.amap.mapcore.animation;

import com.amap.api.maps.model.LatLng;

/* loaded from: classes.dex */
public class GLTranslateAnimation extends GLAnimation {
    public double mToXDelta;
    public double mToYDelta;
    public double mFromXDelta = 0.0d;
    public double mFromYDelta = 0.0d;
    public double mCurXDelta = 0.0d;
    public double mCurYDelta = 0.0d;

    public GLTranslateAnimation(LatLng latLng) {
        this.mToXDelta = 0.0d;
        this.mToYDelta = 0.0d;
        this.mToXDelta = latLng.longitude;
        this.mToYDelta = latLng.latitude;
    }

    @Override // com.autonavi.amap.mapcore.animation.GLAnimation
    public void applyTransformation(float f2, GLTransformation gLTransformation) {
        double d5 = this.mFromXDelta;
        this.mCurXDelta = d5;
        double d8 = this.mFromYDelta;
        this.mCurYDelta = d8;
        double d10 = this.mToXDelta;
        if (d5 != d10) {
            this.mCurXDelta = ((d10 - d5) * f2) + d5;
        }
        double d11 = this.mToYDelta;
        if (d8 != d11) {
            this.mCurYDelta = ((d11 - d8) * f2) + d8;
        }
        gLTransformation.f6572x = this.mCurXDelta;
        gLTransformation.f6573y = this.mCurYDelta;
    }

    public void setFromPoint(LatLng latLng) {
        this.mFromXDelta = latLng.longitude;
        this.mFromYDelta = latLng.latitude;
    }
}
