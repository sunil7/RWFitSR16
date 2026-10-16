package com.amap.api.maps.model.animation;

import com.autonavi.amap.mapcore.animation.GLAlphaAnimation;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: classes.dex */
public class AlphaAnimation extends Animation {

    @JBindingInclude
    private float mFromAlpha;

    @JBindingInclude
    private float mToAlpha;

    public AlphaAnimation(float f2, float f10) {
        this.mFromAlpha = 0.0f;
        this.mToAlpha = 1.0f;
        this.glAnimation = new GLAlphaAnimation(f2, f10);
        this.mFromAlpha = f2;
        this.mToAlpha = f10;
    }

    @Override // com.amap.api.maps.model.animation.Animation
    public String getAnimationType() {
        return "AlphaAnimation";
    }
}
