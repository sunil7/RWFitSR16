package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: classes.dex */
public class RectParticleShape extends ParticleShapeModule {
    private final float bottom;
    private final float left;
    private final float right;
    private final float top;

    public RectParticleShape(float f2, float f10, float f11, float f12, boolean z5) {
        this.left = f2;
        this.top = f10;
        this.right = f11;
        this.bottom = f12;
        this.isUseRatio = z5;
        this.type = 1;
    }

    @Override // com.amap.api.maps.model.particle.ParticleShapeModule
    public float[] getPoint() {
        return null;
    }
}
