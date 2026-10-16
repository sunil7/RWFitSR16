package com.amap.api.maps.model.animation;

import com.autonavi.amap.mapcore.animation.GLRotateAnimation;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: classes.dex */
public class RotateAnimation extends Animation {

    @JBindingInclude
    private float mFromDegrees;

    @JBindingInclude
    private float mToDegrees;

    public RotateAnimation(float f2, float f10, float f11, float f12, float f13) {
        this.mFromDegrees = 0.0f;
        this.mToDegrees = 1.0f;
        this.glAnimation = new GLRotateAnimation(f2, f10, f11, f12, f13);
        this.mFromDegrees = f2;
        this.mToDegrees = f10;
    }

    @Override // com.amap.api.maps.model.animation.Animation
    public String getAnimationType() {
        return "RotateAnimation";
    }

    public RotateAnimation(float f2, float f10) {
        this.mFromDegrees = 0.0f;
        this.mToDegrees = 1.0f;
        this.glAnimation = new GLRotateAnimation(f2, f10, 0.0f, 0.0f, 0.0f);
        this.mFromDegrees = f2;
        this.mToDegrees = f10;
    }
}
