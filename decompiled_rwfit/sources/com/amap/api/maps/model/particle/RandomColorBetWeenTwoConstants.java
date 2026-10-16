package com.amap.api.maps.model.particle;

import com.autonavi.base.amap.mapcore.jbinding.JBindingExclude;
import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.Random;

@JBindingInclude
/* loaded from: classes.dex */
public class RandomColorBetWeenTwoConstants extends ColorGenerate {

    /* renamed from: a, reason: collision with root package name */
    private float f5760a;

    /* renamed from: a1, reason: collision with root package name */
    private float f5761a1;

    /* renamed from: b, reason: collision with root package name */
    private float f5762b;

    /* renamed from: b1, reason: collision with root package name */
    private float f5763b1;

    /* renamed from: g, reason: collision with root package name */
    private float f5764g;

    /* renamed from: g1, reason: collision with root package name */
    private float f5765g1;
    private float r;

    /* renamed from: r1, reason: collision with root package name */
    private float f5766r1;

    @JBindingExclude
    private float[] color = {1.0f, 1.0f, 1.0f, 1.0f};

    @JBindingExclude
    private Random random = new Random();

    @JBindingExclude
    public RandomColorBetWeenTwoConstants(float f2, float f10, float f11, float f12, float f13, float f14, float f15, float f16) {
        this.r = f2 / 255.0f;
        this.f5764g = f10 / 255.0f;
        this.f5762b = f11 / 255.0f;
        this.f5760a = f12 / 255.0f;
        this.f5766r1 = f13 / 255.0f;
        this.f5765g1 = f14 / 255.0f;
        this.f5763b1 = f15 / 255.0f;
        this.f5761a1 = f16 / 255.0f;
        this.type = 0;
    }

    @Override // com.amap.api.maps.model.particle.ColorGenerate
    public float[] getColor() {
        float[] fArr = this.color;
        float nextFloat = this.random.nextFloat();
        float f2 = this.f5766r1;
        float f10 = this.r;
        fArr[0] = l0.a(f2, f10, nextFloat, f10);
        float[] fArr2 = this.color;
        float nextFloat2 = this.random.nextFloat();
        float f11 = this.f5765g1;
        float f12 = this.f5764g;
        fArr2[1] = l0.a(f11, f12, nextFloat2, f12);
        float[] fArr3 = this.color;
        float nextFloat3 = this.random.nextFloat();
        float f13 = this.f5763b1;
        float f14 = this.f5762b;
        fArr3[2] = l0.a(f13, f14, nextFloat3, f14);
        float[] fArr4 = this.color;
        float nextFloat4 = this.random.nextFloat();
        float f15 = this.f5761a1;
        float f16 = this.f5760a;
        fArr4[3] = l0.a(f15, f16, nextFloat4, f16);
        return this.color;
    }
}
