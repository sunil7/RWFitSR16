package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: classes.dex */
public class SinglePointParticleShape extends ParticleShapeModule {
    private float[] point_3;

    public SinglePointParticleShape(float f2, float f10, float f11, boolean z5) {
        this.point_3 = new float[]{f2, f10, f11};
        this.isUseRatio = z5;
        this.type = 0;
    }

    @Override // com.amap.api.maps.model.particle.ParticleShapeModule
    public float[] getPoint() {
        return this.point_3;
    }

    public SinglePointParticleShape(float f2, float f10, float f11) {
        this(f2, f10, f11, false);
    }
}
