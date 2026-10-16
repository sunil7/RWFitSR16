package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.Random;

@JBindingInclude
/* loaded from: classes.dex */
public class RandomVelocityBetweenTwoConstants extends VelocityGenerate {

    @JBindingExclude
    private Random random = new Random();

    /* renamed from: x1, reason: collision with root package name */
    private float f5767x1;

    /* renamed from: x2, reason: collision with root package name */
    private float f5768x2;

    /* renamed from: y1, reason: collision with root package name */
    private float f5769y1;

    /* renamed from: y2, reason: collision with root package name */
    private float f5770y2;
    private float z1;

    /* renamed from: z2, reason: collision with root package name */
    private float f5771z2;

    public RandomVelocityBetweenTwoConstants(float f2, float f10, float f11, float f12, float f13, float f14) {
        this.f5767x1 = f2;
        this.f5769y1 = f10;
        this.z1 = f11;
        this.f5768x2 = f12;
        this.f5770y2 = f13;
        this.f5771z2 = f14;
        this.type = 0;
    }

    @Override // com.amap.api.maps.model.particle.VelocityGenerate
    public float getX() {
        float nextFloat = this.random.nextFloat();
        float f2 = this.f5768x2;
        float f10 = this.f5767x1;
        return l0.a(f2, f10, nextFloat, f10);
    }

    @Override // com.amap.api.maps.model.particle.VelocityGenerate
    public float getY() {
        float nextFloat = this.random.nextFloat();
        float f2 = this.f5770y2;
        float f10 = this.f5769y1;
        return l0.a(f2, f10, nextFloat, f10);
    }

    @Override // com.amap.api.maps.model.particle.VelocityGenerate
    public float getZ() {
        float nextFloat = this.random.nextFloat();
        float f2 = this.f5771z2;
        float f10 = this.z1;
        return l0.a(f2, f10, nextFloat, f10);
    }
}
