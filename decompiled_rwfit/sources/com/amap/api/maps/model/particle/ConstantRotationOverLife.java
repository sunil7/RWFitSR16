package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: classes.dex */
public class ConstantRotationOverLife extends RotationOverLife {
    private float rotate;

    public ConstantRotationOverLife(float f2) {
        this.rotate = f2;
        this.type = 0;
    }

    @Override // com.amap.api.maps.model.particle.RotationOverLife
    public float getRotate() {
        return this.rotate;
    }
}
