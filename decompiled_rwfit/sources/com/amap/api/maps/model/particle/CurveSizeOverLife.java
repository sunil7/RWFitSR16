package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

@JBindingInclude
/* loaded from: classes.dex */
public class CurveSizeOverLife extends SizeOverLife {

    /* renamed from: x, reason: collision with root package name */
    private float f5757x;

    /* renamed from: y, reason: collision with root package name */
    private float f5758y;

    /* renamed from: z, reason: collision with root package name */
    private float f5759z;

    public CurveSizeOverLife(float f2, float f10, float f11) {
        this.f5757x = f2;
        this.f5758y = f10;
        this.f5759z = f11;
        this.type = 0;
    }

    @Override // com.amap.api.maps.model.particle.SizeOverLife
    public float getSizeX(float f2) {
        return 0.0f;
    }

    @Override // com.amap.api.maps.model.particle.SizeOverLife
    public float getSizeY(float f2) {
        return 0.0f;
    }

    @Override // com.amap.api.maps.model.particle.SizeOverLife
    public float getSizeZ(float f2) {
        return 0.0f;
    }
}
