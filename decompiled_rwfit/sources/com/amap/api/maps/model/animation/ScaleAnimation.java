package com.amap.api.maps.model.animation;

import com.autonavi.amap.mapcore.animation.GLScaleAnimation;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: classes.dex */
public class ScaleAnimation extends Animation {

    @JBindingInclude
    private float mFromX;

    @JBindingInclude
    private float mFromY;

    @JBindingInclude
    private float mPivotX;

    @JBindingInclude
    private float mPivotY;

    @JBindingInclude
    private float mToX;

    @JBindingInclude
    private float mToY;

    public ScaleAnimation(float f2, float f10, float f11, float f12) {
        this.glAnimation = new GLScaleAnimation(f2, f10, f11, f12);
        this.mFromX = f2;
        this.mToX = f10;
        this.mFromY = f11;
        this.mToY = f12;
        this.mPivotX = 0.0f;
        this.mPivotY = 0.0f;
        setFillMode(1);
    }

    @Override // com.amap.api.maps.model.animation.Animation
    public String getAnimationType() {
        return "ScaleAnimation";
    }
}
