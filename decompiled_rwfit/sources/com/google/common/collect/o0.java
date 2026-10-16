package com.google.common.collect;

import com.google.android.gms.internal.mlkit_vision_barcode.hb;
import com.google.common.collect.MapMakerInternalMap;

/* loaded from: classes.dex */
public final class o0 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f11104a;

    /* renamed from: b, reason: collision with root package name */
    public int f11105b = -1;

    /* renamed from: c, reason: collision with root package name */
    public int f11106c = -1;

    /* renamed from: d, reason: collision with root package name */
    public MapMakerInternalMap.Strength f11107d;
    public MapMakerInternalMap.Strength e;

    /* renamed from: f, reason: collision with root package name */
    public com.google.common.base.c f11108f;

    public final MapMakerInternalMap.Strength a() {
        MapMakerInternalMap.Strength strength = this.f11107d;
        MapMakerInternalMap.Strength strength2 = MapMakerInternalMap.Strength.STRONG;
        if (strength != null) {
            return strength;
        }
        if (strength2 != null) {
            return strength2;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public final MapMakerInternalMap.Strength b() {
        MapMakerInternalMap.Strength strength = this.e;
        MapMakerInternalMap.Strength strength2 = MapMakerInternalMap.Strength.STRONG;
        if (strength != null) {
            return strength;
        }
        if (strength2 != null) {
            return strength2;
        }
        throw new NullPointerException("Both parameters are null");
    }

    public final String toString() {
        de.o oVar = new de.o(o0.class.getSimpleName());
        int i3 = this.f11105b;
        if (i3 != -1) {
            String valueOf = String.valueOf(i3);
            de.o oVar2 = new de.o(15, false);
            ((de.o) oVar.f12379d).f12379d = oVar2;
            oVar.f12379d = oVar2;
            oVar2.f12378c = valueOf;
            oVar2.f12377b = "initialCapacity";
        }
        int i10 = this.f11106c;
        if (i10 != -1) {
            String valueOf2 = String.valueOf(i10);
            de.o oVar3 = new de.o(15, false);
            ((de.o) oVar.f12379d).f12379d = oVar3;
            oVar.f12379d = oVar3;
            oVar3.f12378c = valueOf2;
            oVar3.f12377b = "concurrencyLevel";
        }
        MapMakerInternalMap.Strength strength = this.f11107d;
        if (strength != null) {
            String a3 = hb.a(strength.toString());
            de.o oVar4 = new de.o(15, false);
            ((de.o) oVar.f12379d).f12379d = oVar4;
            oVar.f12379d = oVar4;
            oVar4.f12378c = a3;
            oVar4.f12377b = "keyStrength";
        }
        MapMakerInternalMap.Strength strength2 = this.e;
        if (strength2 != null) {
            String a10 = hb.a(strength2.toString());
            de.o oVar5 = new de.o(15, false);
            ((de.o) oVar.f12379d).f12379d = oVar5;
            oVar.f12379d = oVar5;
            oVar5.f12378c = a10;
            oVar5.f12377b = "valueStrength";
        }
        if (this.f11108f != null) {
            de.o oVar6 = new de.o(15, false);
            ((de.o) oVar.f12379d).f12379d = oVar6;
            oVar.f12379d = oVar6;
            oVar6.f12378c = "keyEquivalence";
        }
        return oVar.toString();
    }
}
