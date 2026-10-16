package com.amap.api.maps.model.animation;

import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.animation.GLTranslateAnimation;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: classes.dex */
public class TranslateAnimation extends Animation {

    /* renamed from: x, reason: collision with root package name */
    @JBindingInclude
    private double f5755x;

    /* renamed from: y, reason: collision with root package name */
    @JBindingInclude
    private double f5756y;

    public TranslateAnimation(LatLng latLng) {
        this.glAnimation = new GLTranslateAnimation(latLng);
        this.f5755x = latLng.latitude;
        this.f5756y = latLng.longitude;
    }

    @Override // com.amap.api.maps.model.animation.Animation
    public String getAnimationType() {
        return "TranslateAnimation";
    }
}
